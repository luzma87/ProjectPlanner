package android.bootcamp.projectplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.bootcamp.projectplanner.Constants.ADJUSTED_ITERATIONS;
import static android.bootcamp.projectplanner.Constants.ITERATIONS;


public class ProjectPlannerActivity extends Activity {

  private static final int BUFFER_ADJUST_REQUEST_CODE = 3239;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_project_planner);
  }

  public void calculate(View view) {
    int totalPoints = readTextAsInteger(R.id.number_of_points);
    int velocity = readTextAsInteger(R.id.velocity);
    int result = totalPoints / velocity;
    TextView resultView = (TextView) findViewById(R.id.number_of_iterations);
    String resultString = getString(R.string.number_of_iterations) + String.valueOf(result);
    resultView.setText(resultString);
    Intent resultIntent = new Intent(this, ResultActivity.class);
    resultIntent.putExtra(ITERATIONS, result);
    startActivityForResult(resultIntent, BUFFER_ADJUST_REQUEST_CODE);
  }

  private int readTextAsInteger(int resourceIdentifier) {
    return Integer.parseInt(((EditText) findViewById(resourceIdentifier)).getText().toString());
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(resultCode == RESULT_OK){
      int result = data.getIntExtra(ADJUSTED_ITERATIONS, 0);
      String resultString = getString(R.string.adjusted_number_of_iterations) + String.valueOf(result);
      ((TextView)findViewById(R.id.number_of_iterations)).setText(resultString);
    }
  }
}
