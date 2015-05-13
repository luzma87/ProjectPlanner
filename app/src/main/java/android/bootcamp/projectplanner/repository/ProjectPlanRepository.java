package android.bootcamp.projectplanner.repository;

import android.bootcamp.projectplanner.model.Plan;
import android.bootcamp.projectplanner.storage.DataStorageManager;
import android.content.Context;


public class ProjectPlanRepository {
  private DataStorageManager dataStorageManager;

  public ProjectPlanRepository(Context context) {
    dataStorageManager = new DataStorageManager(context);
  }

  public void storePlan(int points, int velocity, int numOfIterations) {
    Plan plan = new Plan(points, velocity, numOfIterations);
    dataStorageManager.store(plan);
  }

}