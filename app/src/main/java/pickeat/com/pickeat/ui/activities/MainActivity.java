package pickeat.com.pickeat.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yalantis.guillotine.animation.GuillotineAnimation;

import pickeat.com.pickeat.R;

public class MainActivity extends AppCompatActivity {

//  private ImageView mToolbarIcon;
//  private TextView mToolbarTitle;
//
//  private TextView mTitleText, mDescriptionText;
//  private ImageView mPickEat, mAdvancedSettings;

  private static final long RIPPLE_DURATION = 300;

  public static Intent getIntent(Context context, boolean newTask) {
    Intent intent = new Intent(context, MainActivity.class);
    if (newTask) {
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initViews();
  }

  private void initViews() {

//    mTitleText = (TextView) findViewById(R.id.main_title_text);
//    mDescriptionText = (TextView) findViewById(R.id.main_desc_text);
//    mPickEat = (ImageView) findViewById(R.id.main_pick_eat);
//    mAdvancedSettings = (ImageView) findViewById(R.id.main_advanced_settings_image);

    FrameLayout root = (FrameLayout) findViewById(R.id.activity_layout);

    ImageView contentHamburger = (ImageView) findViewById(R.id.content_hamburger);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    if (toolbar != null) {
      setSupportActionBar(toolbar);
      getSupportActionBar().setTitle(null);
    }

    View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine_layout, null);
    root.addView(guillotineMenu);

    new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
        .setStartDelay(RIPPLE_DURATION)
        .setActionBarViewForAnimation(toolbar)
        .setClosedOnStart(true)
        .build();

  }

}
