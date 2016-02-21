package com.rokk3rlabs.applist.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class AppInfo {

  @SerializedName("im:name")
  @Expose
  private AppLabel name;
  @SerializedName("im:image")
  @Expose
  private List<AppLabel> images = new ArrayList();
  @Expose
  private AppLabel summary;
  @SerializedName("im:price")
  @Expose
  private AppLabel price;
  @SerializedName("im:contentType")
  @Expose
  private AppLabel contentType;
  @SerializedName("rights")
  @Expose
  private AppLabel rights;
  @SerializedName("title")
  @Expose
  private AppLabel title;
  @SerializedName("id")
  @Expose
  private AppLabel id;

  @SerializedName("im:artist")
  @Expose
  private AppLabel artist;
  @Expose
  private AppLabel category;
  @SerializedName("im:releaseDate")
  @Expose
  private AppLabel releaseDate;

  public AppLabel getName() {
    return name;
  }

  public void setName(AppLabel name) {
    this.name = name;
  }

  public List<AppLabel> getImages() {
    return images;
  }

  public void setImages(List<AppLabel> images) {
    this.images = images;
  }

  public AppLabel getSummary() {
    return summary;
  }

  public void setSummary(AppLabel summary) {
    this.summary = summary;
  }

  public AppLabel getPrice() {
    return price;
  }

  public void setPrice(AppLabel price) {
    this.price = price;
  }

  public AppLabel getContentType() {
    return contentType;
  }

  public void setContentType(AppLabel contentType) {
    this.contentType = contentType;
  }

  public AppLabel getRights() {
    return rights;
  }

  public void setRights(AppLabel rights) {
    this.rights = rights;
  }

  public AppLabel getTitle() {
    return title;
  }

  public void setTitle(AppLabel title) {
    this.title = title;
  }

  public AppLabel getId() {
    return id;
  }

  public void setId(AppLabel id) {
    this.id = id;
  }

  public AppLabel getArtist() {
    return artist;
  }

  public void setArtist(AppLabel artist) {
    this.artist = artist;
  }

  public AppLabel getCategory() {
    return category;
  }

  public void setCategory(AppLabel category) {
    this.category = category;
  }

  public AppLabel getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(AppLabel releaseDate) {
    this.releaseDate = releaseDate;
  }
}
