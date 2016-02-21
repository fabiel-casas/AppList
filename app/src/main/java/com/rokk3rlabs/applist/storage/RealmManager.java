package com.rokk3rlabs.applist.storage;

import android.content.Context;

import com.rokk3rlabs.applist.storage.controllers.AppItemController;

import io.realm.Realm;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class RealmManager {
  private Realm mRealm;
  private static RealmManager realmManager;

  public static RealmManager init(Context context){
    realmManager = new RealmManager();
    realmManager.mRealm = Realm.getInstance(context.getApplicationContext());
    return realmManager;
  }

  public static RealmManager sharedInstance(){
    return realmManager;
  }

  public AppItemController getAppItem(){
    return new AppItemController(mRealm);
  }
}
