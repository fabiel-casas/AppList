package com.fabiel.applist.storage;

import android.content.Context;

import com.fabiel.applist.storage.controllers.AppItemController;


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

  public AppItemController appItem(){
    return new AppItemController(mRealm);
  }
}
