package pickeat.com.pickeat.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pickeat.com.pickeat.R;
import pickeat.com.pickeat.ui.fragments.QuestionFragment;
import pickeat.com.pickeat.ui.fragments.QuestionOptional;
import pickeat.com.pickeat.ui.fragments.questionsFragmentInteractionListener;

public class PickEatExperience extends AppCompatActivity implements questionsFragmentInteractionListener {

  private static final int STATE_FIRST_QUESTION = 1;
  private static final int STATE_SECOND_QUESTION = 2;
  private static final int STATE_THIRD_QUESTION = 3;
  private static final int STATE_FOURTH_QUESTION = 4;

  private int mCurrentState = 1;

  //progress circles layouts
  View[] mProgressViews = new View[4];
  View mOne, mTwo, mThree, mFour;

  FragmentManager mFragmentManager;

  Fragment mQuestionOptional = null;

  public static Intent getIntent(Context context) {
    Intent intent = new Intent(context, PickEatExperience.class);
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pick_eat_experience);
    initViews();
    initFragments();
  }

  private void initViews() {
    mOne = findViewById(R.id.progress_one);
    mTwo = findViewById(R.id.progress_two);
    mThree = findViewById(R.id.progress_three);
    mFour = findViewById(R.id.progress_four);

    mProgressViews[0] = mOne;
    mProgressViews[1] = mTwo;
    mProgressViews[2] = mThree;
    mProgressViews[3] = mFour;
  }

  private void syncProgressIcons() {
    for (int i = 0; i < mCurrentState; i++) {
      mProgressViews[i].setBackgroundResource(R.drawable.circle_white_shape);
    }
  }

  private void initFragments() {
    mFragmentManager = getSupportFragmentManager();

    // Create new fragment and transaction
    mQuestionOptional = new QuestionOptional();
    FragmentTransaction transaction = mFragmentManager.beginTransaction();
    transaction.replace(R.id.fragment_container, mQuestionOptional);
    transaction.commit();
  }

  private void replaceFragment(int questionId) {
    Fragment fragment = QuestionFragment.newInstance(questionId);
    FragmentTransaction transaction = mFragmentManager.beginTransaction();
    transaction.replace(R.id.fragment_container, fragment);
    transaction.commit();
  }

  private void nextFragment(int questionId) {
    switch (mCurrentState) {
      case STATE_FIRST_QUESTION:
        mCurrentState++;
        replaceFragment(questionId);
        break;
      case STATE_SECOND_QUESTION:
        mCurrentState++;
        replaceFragment(questionId);
        break;
      case STATE_THIRD_QUESTION:
        mCurrentState++;
        replaceFragment(questionId);
        break;
      case STATE_FOURTH_QUESTION:
        Toast.makeText(PickEatExperience.this, "THATS IT", Toast.LENGTH_SHORT).show();
        break;
    }
    syncProgressIcons();
  }

  @Override
  public void startQuestions() {
    nextFragment(100);
  }

  @Override
  public void onQuestionAnswered(int answer) {
    //roll next question and send the id with the next fragment.
    nextFragment(answer);
  }

  @Override
  public void onIngredientAdded() {

  }
}
