package pickeat.com.pickeat.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import io.realm.Realm;
import pickeat.com.pickeat.R;
import pickeat.com.pickeat.business.SharedPref;
import pickeat.com.pickeat.model.Constants;
import pickeat.com.pickeat.model.firebase.CategoryQuestions;
import pickeat.com.pickeat.model.firebase.Question;
import pickeat.com.pickeat.model.realm.RealmCategory;

public class SplashScreen extends AppCompatActivity {

  private static final int SPLASH_TIME_IN_MILLIS = 3000;

  private TimerTask mTimerTask = new TimerTask() {
    @Override
    public void run() {

      if (SharedPref.isSigned() && FirebaseAuth.getInstance().getCurrentUser() != null) {
        navigateToMainscreen();
        return;
      }

      navigateToSignup();
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);
    if (SharedPref.isSigned() && FirebaseAuth.getInstance().getCurrentUser() != null) {
      fetchData();
    }
    new Timer().schedule(mTimerTask, SPLASH_TIME_IN_MILLIS);
  }

  private void fetchData() {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    mDatabase.addListenerForSingleValueEvent(
        new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {

            final Realm realm = Realm.getDefaultInstance();

            //TODO - WTF ?
//            Iterator<DataSnapshot> snap = dataSnapshot.child(Constants.FIRE_QUESTIONS).getChildren().iterator();
//            while (snap.hasNext()) {
//              DataSnapshot dataSnapshot1 = snap.next();
//              String categoryName = dataSnapshot1.getKey();
//              Map<String, Question> questionsMap = (Map<String, Question>) dataSnapshot1.getValue();
//              RealmCategory.saveCategory(realm, categoryName, questionsMap);
//            }

//            Map<String, Question> objectMap = (Map<String, Question>) dataSnapshot.child(Constants.FIRE_QUESTIONS).child(Constants.FIRE_FOOD_TYPE).getValue();
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {
            Log.w("blabla ", "getUser:onCancelled", databaseError.toException());
            // ...
          }
        });
  }

  private void navigateToMainscreen() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        startActivity(MainActivity.getIntent(SplashScreen.this, true));
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //todo - add animations.
      }
    });
  }

  private void navigateToSignup() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        startActivity(SignupActivity.getIntent(SplashScreen.this, true));
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //todo - add animations.
      }
    });
  }
}
