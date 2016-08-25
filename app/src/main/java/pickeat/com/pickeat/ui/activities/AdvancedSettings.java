package pickeat.com.pickeat.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pickeat.com.pickeat.R;

public class AdvancedSettings extends AppCompatActivity {

  private TextView mTitleText, mDescriptionText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_advanced_settings);

    mTitleText = (TextView) findViewById(R.id.advanced_settings_title_text);
    mDescriptionText = (TextView) findViewById(R.id.advanced_settings_desc_text);

  }
}
