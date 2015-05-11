package android.bootcamp.projectplanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ProjectPlannerActivity extends Activity {

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
  }

  private int readTextAsInteger(int resourceIdentifier) {
    return Integer.parseInt(((EditText) findViewById(resourceIdentifier)).getText().toString());
  }
}
