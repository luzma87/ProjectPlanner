package android.bootcamp.projectplanner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import static android.bootcamp.projectplanner.Constants.ITERATIONS;


public class ResultActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);
    int result = getIntent().getIntExtra(ITERATIONS, 0);
    ((TextView)findViewById(R.id.result)).setText(String.valueOf(result));
  }
}
