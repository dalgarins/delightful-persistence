package com.alexsimo.delightfulpersistence.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.alexsimo.delightfulpersistence.database.model.AuthorModel;
import com.alexsimo.delightfulpersistence.database.model.BookAuthorModel;
import com.alexsimo.delightfulpersistence.database.model.BookModel;
import com.alexsimo.delightfulpersistence.runner.CustomRunner;
import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DatabaseShould extends CustomRunner {

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    DbCommon.deleteDatabase(context);
  }

  @Test
  public void be_able_to_open_writable_database() throws Exception {
    SQLiteDatabase db = givenWritableDatabase();

    assertTrue(db.isOpen());
    assertTrue(!db.isReadOnly());
  }

  @Test
  public void have_created_tables() throws Exception {
    SQLiteDatabase db = givenWritableDatabase();
    HashSet<String> tables = givenAllTables();

    Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
    cursor.moveToFirst();
    do {
      String table = cursor.getString(0);
      tables.remove(table);
    } while (cursor.moveToNext());
    cursor.close();

    assertTrue(tables.isEmpty());
  }

  private SQLiteDatabase givenWritableDatabase() {
    return DbCommon.givenWritableDatabase(context);
  }

  private HashSet<String> givenAllTables() {
    HashSet<String> tables = new HashSet<>();
    tables.add(BookModel.TABLE_NAME);
    tables.add(AuthorModel.TABLE_NAME);
    tables.add(BookAuthorModel.TABLE_NAME);
    return tables;
  }
}
