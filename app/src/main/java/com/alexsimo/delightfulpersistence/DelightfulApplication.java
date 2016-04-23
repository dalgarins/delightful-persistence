package com.alexsimo.delightfulpersistence;

import android.app.Application;
import com.alexsimo.delightfulpersistence.database.DatabaseManager;
import com.alexsimo.delightfulpersistence.database.DelightfulOpenHelper;

public class DelightfulApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    DatabaseManager.initialize(DelightfulOpenHelper.getInstance(this));
  }
}
