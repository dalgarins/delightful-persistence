package com.alexsimo.delightfulpersistence.database;

import com.alexsimo.delightfulpersistence.database.model.AuthorModel;
import com.alexsimo.delightfulpersistence.runner.CustomRunner;
import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

public class AuthorTableShould extends CustomRunner {

  @Before
  public void setUp() throws Exception {
    super.setUp();
    DbCommon.deleteDatabase(context);
  }

  @Test
  public void have_created_all_columns() throws Exception {


  }

  private HashSet<String> givenAuthorColumns() {
    HashSet<String> columns = new HashSet<>();
    columns.add(AuthorModel._ID);
    columns.add(AuthorModel.NAME);
    columns.add(AuthorModel.BIRTH_YEAR);
    return columns;
  }
}
