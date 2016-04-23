package com.alexsimo.delightfulpersistence.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbCommon {

  public static void deleteDatabase(Context context) {
    context.deleteDatabase(DelightfulOpenHelper.DB_NAME);
  }

  public static SQLiteDatabase givenWritableDatabase(Context context) {
    return DelightfulOpenHelper.getInstance(context).getWritableDatabase();
  }
}
