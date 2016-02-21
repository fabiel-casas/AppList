package com.rokk3rlabs.applist.api.models;

import com.google.gson.annotations.Expose;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class ItunesRes {
  @Expose
  private AppFeed feed;

  public AppFeed getFeed() {
    return feed;
  }

  public void setFeed(AppFeed feed) {
    this.feed = feed;
  }
}
