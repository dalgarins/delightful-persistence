package com.alexsimo.delightfulpersistence.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alexsimo.delightfulpersistence.database.model.AuthorModel;
import com.alexsimo.delightfulpersistence.database.model.BookModel;
import com.alexsimo.delightfulpersistence.database.populator.AuthorPopulator;
import com.alexsimo.delightfulpersistence.database.populator.BookPopulator;

public class DelightfulOpenHelper extends SQLiteOpenHelper {

  private static final String DB_NAME = "delightful.db";
  private static final int DB_VERSION = 1;

  private static DelightfulOpenHelper instance;

  public static DelightfulOpenHelper getInstance(Context context) {
    if (null == instance) {
      instance = new DelightfulOpenHelper(context);
    }
    return instance;
  }

  private DelightfulOpenHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(BookModel.CREATE_TABLE);
    db.execSQL(AuthorModel.CREATE_TABLE);
    populate(db);
  }

  private void populate(SQLiteDatabase db) {
    AuthorPopulator.populate(db);
    BookPopulator.populate(db);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }
}
