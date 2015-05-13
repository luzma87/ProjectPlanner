package android.bootcamp.projectplanner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.bootcamp.projectplanner.repository.ProjectPlanRepository;
import android.widget.Toast;


import static android.bootcamp.projectplanner.Constants.ADJUSTED_ITERATIONS;
import static android.bootcamp.projectplanner.Constants.ITERATIONS;


public class ProjectPlannerActivity extends Activity {

  private static final int BUFFER_ADJUST_REQUEST_CODE = 3239;
  private static final int IMAGE_CAPTURE_REQUEST_CODE = 2827;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_project_planner);
  }

  public void calculate(View view) {
    int totalPoints = readTextAsInteger(R.id.number_of_points);
    int velocity = readTextAsInteger(R.id.velocity);
    int result = totalPoints / velocity;
    TextView label = (TextView) findViewById(R.id.label_num_of_iterations);
    label.setText(R.string.number_of_iterations);

    TextView resultView = (TextView) findViewById(R.id.number_of_iterations);
    String resultString = String.valueOf(result);
    resultView.setText(resultString);

    Intent resultIntent = new Intent(this, ResultActivity.class);
    resultIntent.putExtra(ITERATIONS, result);
    startActivityForResult(resultIntent, BUFFER_ADJUST_REQUEST_CODE);
  }

  public void captureImage(View view) {
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(intent, IMAGE_CAPTURE_REQUEST_CODE);
  }

  private int readTextAsInteger(int resourceIdentifier) {
    return Integer.parseInt(((EditText) findViewById(resourceIdentifier)).getText().toString());
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK) {
      if (requestCode == BUFFER_ADJUST_REQUEST_CODE) {
        int result = data.getIntExtra(ADJUSTED_ITERATIONS, 0);
        TextView label = (TextView) findViewById(R.id.label_num_of_iterations);
        label.setText(R.string.adjusted_number_of_iterations);

        String resultString = String.valueOf(result);
        ((TextView) findViewById(R.id.number_of_iterations)).setText(resultString);
      }
      else if (requestCode == IMAGE_CAPTURE_REQUEST_CODE && data != null) {
        showImage((Bitmap) data.getExtras().get("data"));
      }
    }
  }

  private void showImage(Bitmap data) {
    ImageView issueImageView = (ImageView) findViewById(R.id.capturedImage);
    issueImageView.setImageBitmap(data);
  }

  public void store(View view) {
    ProjectPlanRepository projectPlanRepository = new ProjectPlanRepository(this);
    int totalPoints = readTextAsInteger(R.id.number_of_points);
    int velocity = readTextAsInteger(R.id.velocity);
    int numOfIterations = Integer.parseInt(((TextView) findViewById(R.id.number_of_iterations)).getText().toString());
    projectPlanRepository.storePlan(totalPoints, velocity, numOfIterations);
    Toast.makeText(this, "Saved in DB", Toast.LENGTH_SHORT).show();
  }
}
