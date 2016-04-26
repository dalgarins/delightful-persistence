package com.alexsimo.delightfulpersistence.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.alexsimo.delightfulpersistence.database.model.Author;
import com.alexsimo.delightfulpersistence.database.model.AuthorModel;
import com.alexsimo.delightfulpersistence.runner.CustomRunner;
import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AuthorTableShould extends CustomRunner {

  @Before
  public void setUp() throws Exception {
    super.setUp();
    DbCommon.deleteDatabase(context);
  }

  @Test
  public void have_created_all_columns() throws Exception {
    HashSet<String> columns = givenAuthorColumns();
    SQLiteDatabase db = givenWritableDatabase();
    Cursor cursor = db.rawQuery("PRAGMA table_info(" + AuthorModel.TABLE_NAME + ")", null);

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

  @Test
  public void be_able_to_return_cursor_with_all_default_authors() throws Exception {
    SQLiteDatabase db = givenWritableDatabase();

    Cursor cursor = db.rawQuery(AuthorModel.SELECT_ALL, new String[0]);

    int AUTHOR_COUNT = 5;
    assertTrue(cursor.getCount() == AUTHOR_COUNT);
  }

  @Test
  public void map_cursor_with_domain_model() throws Exception {
    SQLiteDatabase db = givenWritableDatabase();

    Cursor cursor = db.rawQuery(AuthorModel.SELECT_ALL, new String[0]);
    cursor.moveToFirst();

    Author author = Author.MAPPER.map(cursor);
    assertNotNull(author);
  }

  private SQLiteDatabase givenWritableDatabase() {
    return DbCommon.givenWritableDatabase(context);
  }

  private HashSet<String> givenAuthorColumns() {
    HashSet<String> columns = new HashSet<>();
    columns.add(AuthorModel._ID);
    columns.add(AuthorModel.NAME);
    columns.add(AuthorModel.BIRTH_YEAR);
    return columns;
  }
}
