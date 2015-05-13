package android.bootcamp.projectplanner.storage;

import android.bootcamp.projectplanner.model.Plan;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataStorageManager extends SQLiteOpenHelper {
  private static final String TABLE_NAME = "plan";
  private static final String POINTS_COL = "points";
  private static final String VELOCITY_COL = "velocity";
  private static final String ITERATIONS_COL = "iterations";
  private static final String DB_NAME = "plan.db";

  public DataStorageManager(Context context) {
    super(context, DB_NAME, null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase db) { //create your database
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  }


  public void store(Plan plan) { //insert into your database
  }

}