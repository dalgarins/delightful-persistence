package com.alexsimo.delightfulpersistence.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbCommon {

  public static void deleteDatabase(Context context) {
    context.deleteDatabase(DelightfulOpenHelper.DB_NAME);
  }

  public static void closeDatabase() {
    DatabaseManager.getInstance().closeDatabase();
  }

  public static void initializeDatabase(Context context) {
    DatabaseManager.initialize(DelightfulOpenHelper.getInstance(context));
  }

  public static SQLiteDatabase getOpenedDatabase() {
    return DatabaseManager.getInstance().openDatabase();
  }

  public static SQLiteDatabase givenWritableDatabase(Context context) {
    return DelightfulOpenHelper.getInstance(context).getWritableDatabase();
    /*DatabaseManager.initialize(DelightfulOpenHelper.getInstance(context));*/
    //return DatabaseManager.getInstance().openDatabase();
  }
}
