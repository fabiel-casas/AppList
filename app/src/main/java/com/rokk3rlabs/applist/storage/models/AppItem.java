package com.rokk3rlabs.applist.storage.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class AppItem extends RealmObject {
  @PrimaryKey
  private String id;
  private String name;
  private String images;
  private String description;
  private String price;
  private String contentType;
  private String rights;
  private String title;
  private String artist;
  private String categoryId;
  private String category;
  private String releaseDate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getRights() {
    return rights;
  }

  public void setRights(String rights) {
    this.rights = rights;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }
}
