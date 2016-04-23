package com.alexsimo.delightfulpersistence.database;

import android.content.Context;
import com.alexsimo.delightfulpersistence.database.model.AuthorModel;
import com.alexsimo.delightfulpersistence.database.model.BookAuthorModel;
import com.alexsimo.delightfulpersistence.database.model.BookModel;
import com.alexsimo.delightfulpersistence.runner.CustomRunner;
import java.util.HashSet;
import org.junit.Before;

public class DatabaseShould extends CustomRunner {

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    deleteDatabase();
  }



  private void deleteDatabase() {
    context.deleteDatabase(DelightfulOpenHelper.DB_NAME);
  }

  private HashSet<String> tables() {
    HashSet<String> tables = new HashSet<>();
    tables.add(BookModel.TABLE_NAME);
    tables.add(AuthorModel.TABLE_NAME);
    tables.add(BookAuthorModel.TABLE_NAME);
    return tables;
  }
}
