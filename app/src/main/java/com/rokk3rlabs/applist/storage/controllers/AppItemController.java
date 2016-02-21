package com.rokk3rlabs.applist.storage.controllers;

import com.rokk3rlabs.applist.storage.models.AppItem;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class AppItemController {

  private Realm mRealm;

  public AppItemController(Realm realm) {
    this.mRealm = realm;
  }

  public RealmResults<AppItem> getAppLocalList(){
    return mRealm.where(AppItem.class).findAll();
  }

}
