package pickeat.com.pickeat.business;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.firebase.auth.FirebaseUser;

import pickeat.com.pickeat.BaseApplication;
import pickeat.com.pickeat.model.Constants;

/**
 * Created by Refael Ozeri on 25/08/2016.
 */
public class SharedPref {

  //initialize the shared pref.
  private static SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getInstance());

  public static void saveRegisteredUser(FirebaseUser user) {
    mSharedPreferences.edit().putBoolean(Constants.SP_IS_SIGNED, true).apply();
    mSharedPreferences.edit().putString(Constants.SP_UID, user.getUid()).apply();
    mSharedPreferences.edit().putString(Constants.SP_DISPLAY_NAME, user.getDisplayName()).apply();
    mSharedPreferences.edit().putString(Constants.SP_EMAIL, user.getEmail()).apply();
  }

  public static boolean isSigned() {
    return mSharedPreferences.getBoolean(Constants.SP_IS_SIGNED, false);
  }

  public static String getUid() {
    return mSharedPreferences.getString(Constants.SP_UID, "");
  }

  public static String getDisplayName() {
    return mSharedPreferences.getString(Constants.SP_DISPLAY_NAME, "");
  }

  public static String getEmail() {
    return mSharedPreferences.getString(Constants.SP_EMAIL, "");
  }

  public static void saveQuestionVersion(int version) {
    mSharedPreferences.edit().putInt(Constants.FIRE_QUESTIONS_VERSION, version).apply();
  }

  public static int getQuestionVersion() {
    return mSharedPreferences.getInt(Constants.FIRE_QUESTIONS_VERSION, 0);
  }

}
