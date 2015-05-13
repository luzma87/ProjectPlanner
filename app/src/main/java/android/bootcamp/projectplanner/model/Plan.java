package android.bootcamp.projectplanner.model;

public class Plan {
  private int points;
  private int velocity;
  private int numOfIterations;

  public Plan(int points, int velocity, int numOfIterations) {
    this.points = points;
    this.velocity = velocity;
    this.numOfIterations = numOfIterations;
  }

  public int getVelocity() {
    return velocity;
  }

  public int getNumOfIterations() {
    return numOfIterations;
  }

  public int getPoints() {
    return points;
  }

}