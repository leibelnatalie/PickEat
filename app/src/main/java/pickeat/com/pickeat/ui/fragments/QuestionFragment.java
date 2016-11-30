package pickeat.com.pickeat.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import pickeat.com.pickeat.R;
import pickeat.com.pickeat.model.realm.RealmQuestion;
import pickeat.com.pickeat.ui.activities.PickEatExperience;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link questionsFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener {

  private static final String QUESTION_ID = "QUESTION_ID";

  private final int QUESTION_DELAY_IN_MILLIS = 500;

  private int mAnsweredOption = 0;
  private int mQuestionId = 0;

  private RealmQuestion mQuestion;

  private questionsFragmentInteractionListener mListener;

  //questions layout
  private RelativeLayout mOne, mTwo, mThree, mFour;

  public QuestionFragment() {
    // Required empty public constructor
  }

  public static QuestionFragment newInstance(int questionId) {
    QuestionFragment fragment = new QuestionFragment();
    Bundle args = new Bundle();
    args.putInt(QUESTION_ID, questionId);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null && getActivity() != null) {
      mQuestionId = getArguments().getInt(QUESTION_ID);
      mQuestion = ((PickEatExperience)getActivity()).getCurrentQuestion(mQuestionId);
    }

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_question, container, false);
    initViews(view);
    return view;
  }

  private void initViews(View view) {
    ((TextView)view.findViewById(R.id.question_title)).setText(mQuestion.getQuestion());

    ((TextView) view.findViewById(R.id.question_text_1)).setText(mQuestion.getAnswer1().getAnswer());
    ((TextView) view.findViewById(R.id.question_text_2)).setText(mQuestion.getAnswer2().getAnswer());
    ((TextView) view.findViewById(R.id.question_text_3)).setText(mQuestion.getAnswer3().getAnswer());
    ((TextView) view.findViewById(R.id.question_text_4)).setText(mQuestion.getAnswer4().getAnswer());

    mOne = (RelativeLayout) view.findViewById(R.id.question_layout_1);
    mTwo = (RelativeLayout) view.findViewById(R.id.question_layout_2);
    mThree = (RelativeLayout) view.findViewById(R.id.question_layout_3);
    mFour = (RelativeLayout) view.findViewById(R.id.question_layout_4);

    mOne.setOnClickListener(this);
    mTwo.setOnClickListener(this);
    mThree.setOnClickListener(this);
    mFour.setOnClickListener(this);
  }

  public void onAnswerSelected(int answer) {
    if (mListener != null) {
      mListener.onQuestionAnswered(answer);
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof questionsFragmentInteractionListener) {
      mListener = (questionsFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  @Override
  public void onClick(View v) {
    int answer = 0;
    switch (v.getId()) {
      case R.id.question_layout_1:
        answer = 1;
        break;
      case R.id.question_layout_2:
        answer = 2;
        break;
      case R.id.question_layout_3:
        answer = 3;
        break;
      case R.id.question_layout_4:
        answer = 4;
        break;
    }
    if (answer != 0) {
      answerPicked(answer, v);
    }
  }

  private void answerPicked(final int answer, View view) {

    disableLayouts();

    deselectLayouts(view.getId());

    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        if (getActivity() != null) {
          getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
              onAnswerSelected(answer);
            }
          });
        }
      }
    }, QUESTION_DELAY_IN_MILLIS);
  }

  private void disableLayouts() {
    mOne.setClickable(false);
    mTwo.setClickable(false);
    mThree.setClickable(false);
    mFour.setClickable(false);
  }

  //hides the layouts except the clicked layout
  private void deselectLayouts(int id) {
    if (mOne.getId() != id) fadeOutLayout(mOne);//mOne.setAlpha(0.7f);
    if (mTwo.getId() != id) fadeOutLayout(mTwo);//mTwo.setAlpha(0.7f);
    if (mThree.getId() != id) fadeOutLayout(mThree);//mThree.setAlpha(0.7f);
    if (mFour.getId() != id) fadeOutLayout(mFour);//mFour.setAlpha(0.7f);
  }

  private void fadeOutLayout(View view) {
    AlphaAnimation animation1 = new AlphaAnimation(1.0f, 0.6f);
    animation1.setDuration(300);
    animation1.setFillAfter(true);
    view.startAnimation(animation1);
  }

}
