package com.fabiel.applist.storage.controllers;

import com.fabiel.applist.api.models.AppInfo;
import com.fabiel.applist.api.models.AppLabel;
import com.fabiel.applist.storage.models.AppCategory;
import com.fabiel.applist.storage.models.AppImage;
import com.fabiel.applist.storage.models.AppItem;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class AppItemController {

  private Realm mRealm;

  public AppItemController(Realm realm) {
    this.mRealm = realm;
  }

  /**
   * retrieve all app item in the local storage
   * @return
   */
  public RealmResults<AppItem> getAppLocalList(){
    return mRealm.where(AppItem.class).findAll();
  }

  /**
   * retrieve all app item in one category
   * @param categoryId
   * @return
   */
  public RealmResults<AppItem> getAppLocalListByCategory(String categoryId){
    return mRealm.where(AppItem.class).equalTo("category.id", categoryId).findAll();
  }

  /**
   * retrieve a app item searching by id
   * @param id
   * @return
   */
  public AppItem getAppItemById(String id){
    return mRealm.where(AppItem.class).equalTo("id", id).findFirst();
  }

  /**
   * create every app time in the list
   * @param appInfoList
   */
  public void createAppItems(List<AppInfo> appInfoList) {
    mRealm.beginTransaction();
    for(AppInfo appInfo : appInfoList){
      AppItem appItem = getAppItemById(appInfo.getId().getAttributes().getId());
      if(appItem == null){
        AppItem newAppItem = mRealm.createObject(AppItem.class);
        newAppItem.setId(appInfo.getId().getAttributes().getId());
        newAppItem.setName(appInfo.getName().getLabel());
        newAppItem.setTitle(appInfo.getTitle().getLabel());
        newAppItem.setArtist(appInfo.getArtist().getLabel());
        newAppItem.setDescription(appInfo.getSummary().getLabel());
        AppCategory category = getCategoryById(appInfo.getCategory().getAttributes().getId());
        if(category == null){
          category = mRealm.createObject(AppCategory.class);
          category.setId(appInfo.getCategory().getAttributes().getId());
          category.setName(appInfo.getCategory().getAttributes().getLabel());
        }
        newAppItem.setCategory(category);
        newAppItem.setContentType(appInfo.getContentType().getAttributes().getLabel());
        newAppItem.setPrice(appInfo.getPrice().getAttributes().getAmount());
        newAppItem.setRights(appInfo.getRights().getLabel());
        newAppItem.setLink(appInfo.getId().getLabel());
        newAppItem.setReleaseDate(appInfo.getReleaseDate().getAttributes().getLabel());
        newAppItem.setImages(new RealmList<AppImage>());
        for(AppLabel appLabel : appInfo.getImages()){
          AppImage appImage = mRealm.createObject(AppImage.class);
          appImage.setUrlImage(appLabel.getLabel());
          appImage.setHeight(appLabel.getAttributes().getHeight());
          newAppItem.getImages().add(appImage);
        }
      }
    }
    mRealm.commitTransaction();
  }

  /**
   * get one category searching by id
   * @param id
   * @return
   */
  private AppCategory getCategoryById(String id) {
    return mRealm.where(AppCategory.class).equalTo("id", id).findFirst();
  }

  /**
   * get list of categories
   * @return
   */
  public RealmResults<AppCategory> getCategoryList() {
    return mRealm.where(AppCategory.class).findAll();
  }

}
