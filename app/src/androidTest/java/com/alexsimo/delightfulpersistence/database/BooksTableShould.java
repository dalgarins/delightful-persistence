package com.alexsimo.delightfulpersistence.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.alexsimo.delightfulpersistence.database.model.AuthorModel;
import com.alexsimo.delightfulpersistence.database.model.BookModel;
import com.alexsimo.delightfulpersistence.runner.CustomRunner;
import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BooksTableShould extends CustomRunner {

  @Before
  public void setUp() throws Exception {
    super.setUp();
    DbCommon.deleteDatabase(context);
  }

  @Test
  public void have_created_all_columns() throws Exception {
    HashSet<String> columns = givenAuthorColumns();
    SQLiteDatabase db = givenWritableDatabase();
    Cursor cursor = db.rawQuery("PRAGMA table_info(" + BookModel.TABLE_NAME + ")", null);

    cursor.moveToFirst();
    int columnNameIndex = cursor.getColumnIndex("name");
    do {
      String columnName = cursor.getString(columnNameIndex);
      columns.remove(columnName);
    } while (cursor.moveToNext());

    assertTrue(columns.isEmpty());
    cursor.close();
    db.close();
  }

  private SQLiteDatabase givenWritableDatabase() {
    return DbCommon.givenWritableDatabase(context);
  }

  private HashSet<String> givenAuthorColumns() {
    HashSet<String> columns = new HashSet<>();
    columns.add(BookModel._ID);
    columns.add(BookModel.TITLE);
    columns.add(BookModel.ISBN);
    columns.add(BookModel.RELEASE_YEAR);
    return columns;
  }
}
