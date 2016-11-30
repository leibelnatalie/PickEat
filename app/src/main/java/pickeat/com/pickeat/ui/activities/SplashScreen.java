package pickeat.com.pickeat.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Timer;
import java.util.TimerTask;

import pickeat.com.pickeat.R;
import pickeat.com.pickeat.business.SharedPref;
import pickeat.com.pickeat.business.firebase.FirebaseUtil;

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
    FirebaseUtil.checkQuestionsVersion();
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
