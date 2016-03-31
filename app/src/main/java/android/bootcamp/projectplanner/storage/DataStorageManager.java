package android.bootcamp.projectplanner.storage;

import android.bootcamp.projectplanner.model.Plan;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.provider.BaseColumns._ID;


public class DataStorageManager extends SQLiteOpenHelper {
  private static final String TABLE_NAME = "plan";
  private static final String POINTS_COL = "points";
  private static final String VELOCITY_COL = "velocity";
  private static final String ITERATIONS_COL = "iterations";
  private static final String DB_NAME = "plan.db";
  private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + _ID
      + " INTEGER PRIMARY KEY AUTOINCREMENT, " + POINTS_COL
      + " INTEGER NOT NULL ," + VELOCITY_COL + " INTEGER NOT NULL ," + ITERATIONS_COL + " INTEGER NOT NULL );";


  public DataStorageManager(Context context) {
    super(context, DB_NAME, null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  }


  public void store(Plan plan) {
    SQLiteDatabase db = getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(POINTS_COL, plan.getPoints());
    values.put(VELOCITY_COL, plan.getVelocity());
    values.put(ITERATIONS_COL, plan.getNumOfIterations());

    db.insert(TABLE_NAME, null, values);
  }

}