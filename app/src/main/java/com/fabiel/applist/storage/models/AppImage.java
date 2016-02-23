package com.fabiel.applist.storage.models;

import io.realm.RealmObject;

/**
 * Created by JohanFabiel on 21/02/2016.
 */
public class AppImage extends RealmObject {
  private String urlImage;
  private String height;

  public String getUrlImage() {
    return urlImage;
  }

  public void setUrlImage(String urlImage) {
    this.urlImage = urlImage;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }
}
