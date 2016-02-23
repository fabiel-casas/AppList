package com.fabiel.applist.api.models;

import com.google.gson.annotations.Expose;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class AppLabel {
  @Expose
  private String label;
  @Expose
  private Attributes attributes;

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Attributes getAttributes() {
    return attributes;
  }

  public void setAttributes(Attributes attributes) {
    this.attributes = attributes;
  }
}
