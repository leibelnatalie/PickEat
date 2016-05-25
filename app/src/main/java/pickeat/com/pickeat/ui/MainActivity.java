package pickeat.com.pickeat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pickeat.com.pickeat.R;

public class MainActivity extends AppCompatActivity {

  private ImageView mToolbarIcon;
  private TextView mToolbarTitle;

  private TextView mTitleText, mDescriptionText;
  private ImageView mPickEat, mAdvancedSettings;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    initViews();
  }

  private void initViews() {

    initToolbar();

    mTitleText = (TextView) findViewById(R.id.main_title_text);
    mDescriptionText = (TextView) findViewById(R.id.main_desc_text);
    mPickEat = (ImageView) findViewById(R.id.main_pick_eat);
    mAdvancedSettings = (ImageView) findViewById(R.id.main_advanced_settings_image);

  }

  private void initToolbar() {
    mToolbarTitle = (TextView) findViewById(R.id.toolbar_text);
    mToolbarIcon = (ImageView) findViewById(R.id.toolbar_icon);

    mToolbarTitle.setText(R.string.toolbar_mainscreen_title);
  }


}
