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

import com.yalantis.guillotine.animation.GuillotineAnimation;

import pickeat.com.pickeat.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    findViewById(R.id.main_pickeat_btn).setOnClickListener(this);
    findViewById(R.id.main_quickpick_btn).setOnClickListener(this);

    FrameLayout root = (FrameLayout) findViewById(R.id.activity_layout);

    ImageView contentHamburger = (ImageView) findViewById(R.id.content_hamburger);

    Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
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

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.main_pickeat_btn:
        startActivity(PickEatExperience.getIntent(MainActivity.this));
        break;
      case R.id.main_quickpick_btn:
        break;
    }
  }
}
