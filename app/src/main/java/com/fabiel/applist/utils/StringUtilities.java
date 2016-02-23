package com.fabiel.applist.utils;

/**
 * Created by JohanFabiel on 22/02/2016.
 */
public class StringUtilities {

  /**
   * validate if application is free or concat money symbol on the string
   * @param price
   * @return
   */
  public static String getPrice(String price) {
    float realPrice = Float.parseFloat(price);
    return (realPrice == 0) ? "Free" : "$"+realPrice;
  }
}
