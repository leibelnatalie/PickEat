package pickeat.com.pickeat;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Refael Ozeri on 25/08/2016.
 */
public class BaseApplication extends Application {

  private static BaseApplication singleton;
  public static BaseApplication getInstance() {
    return singleton;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    singleton = this;

    setRealmDefaultConfiguration();


  }

  private void setRealmDefaultConfiguration() {
    RealmConfiguration config = new RealmConfiguration.Builder(this).build();
    Realm.setDefaultConfiguration(config);
  }
}
