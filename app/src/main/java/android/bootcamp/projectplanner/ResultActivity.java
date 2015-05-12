package android.bootcamp.projectplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.bootcamp.projectplanner.Constants.ADJUSTED_ITERATIONS;
import static android.bootcamp.projectplanner.Constants.ITERATIONS;


public class ResultActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);
    int result = rawNumberOfIterations();
    ((TextView)findViewById(R.id.number_of_iterations)).setText(getString(R.string.number_of_iterations) + String.valueOf(result));
  }

  private int rawNumberOfIterations() {
    return getIntent().getIntExtra(ITERATIONS, 0);
  }

  public void adjust(View view) {
    int rawNumberOfIterations = rawNumberOfIterations();
    int buffer = Integer.parseInt(((EditText) findViewById(R.id.buffer)).getText().toString());
    int adjustedNumberOfIterations = rawNumberOfIterations + buffer;
    Intent intent = new Intent();
    intent.putExtra(ADJUSTED_ITERATIONS, adjustedNumberOfIterations);
    setResult(RESULT_OK, intent);
    finish();
  }
}
