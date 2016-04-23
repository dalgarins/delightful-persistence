package com.alexsimo.delightfulpersistence;

import com.alexsimo.delightfulpersistence.database.DatabaseTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    DatabaseTestSuite.class
})
public class FullTestSuite {
}