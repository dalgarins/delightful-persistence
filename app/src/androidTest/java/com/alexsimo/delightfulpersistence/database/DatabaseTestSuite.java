package com.alexsimo.delightfulpersistence.database;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AuthorBookTableShould.class,
    AuthorTableShould.class,
    BooksTableShould.class,
    DatabaseShould.class
})
public class DatabaseTestSuite {
}
