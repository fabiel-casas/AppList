package com.rokk3rlabs.applist.app;

import android.app.Application;

import com.rokk3rlabs.applist.storage.RealmManager;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    RealmManager.init(this);
  }
}
