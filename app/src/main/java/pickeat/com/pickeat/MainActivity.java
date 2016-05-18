package pickeat.com.pickeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private TextView mTitleText, mDescriptionText;
  private ImageView mPickEat, mAdvancedSettings;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mTitleText = (TextView) findViewById(R.id.main_title_text);
    mDescriptionText = (TextView) findViewById(R.id.main_desc_text);

    mPickEat = (ImageView) findViewById(R.id.main_pick_eat);
    mAdvancedSettings = (ImageView) findViewById(R.id.main_advanced_settings);
  }

}
