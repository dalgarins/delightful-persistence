package com.alexsimo.delightfulpersistence;

import com.facebook.stetho.Stetho;

public class DebugDelightfulApplication extends DelightfulApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    initStetho();
  }

  private void initStetho() {
    Stetho.initialize(Stetho.newInitializerBuilder(getApplicationContext())
        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(getApplicationContext()))
        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
        .build());
  }
}
