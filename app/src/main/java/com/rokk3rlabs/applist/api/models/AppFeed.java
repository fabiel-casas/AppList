package com.rokk3rlabs.applist.api.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class AppFeed {

  @Expose
  private List<AppInfo> entry = new ArrayList<>();

  public List<AppInfo> getEntry() {
    return entry;
  }

  public void setEntry(List<AppInfo> entry) {
    this.entry = entry;
  }
}
