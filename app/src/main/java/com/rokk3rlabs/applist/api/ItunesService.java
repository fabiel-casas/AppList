package com.rokk3rlabs.applist.api;

import com.rokk3rlabs.applist.api.models.ItunesRes;

import retrofit.Callback;

import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class ItunesService {

  //https://itunes.apple.com/us/rss/topfreeapplications/limit=10/json
  public static final String ENDPOINT = "https://itunes.apple.com";
  public static final String COUNTRY_US = "us";
  public static final String TYPE_CALL = "topfreeapplications";
  public static final String TYPE_RESPONSE = "json";
  public static final int LIMIT = 10;
  public static final String LIMIT_NUM = "limit="+LIMIT;

  private ItunesApi itunesApi;

  public ItunesService(ItunesApi itunesApi) {
    this.itunesApi = itunesApi;
  }

  public static ItunesService getInstance(){
    RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint(ENDPOINT)
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build();
    return new ItunesService(restAdapter.create(ItunesApi.class));
  }

  public void rxRequestAppsList(Callback<ItunesRes> callback){
    itunesApi.requestAppsList(COUNTRY_US, TYPE_CALL, LIMIT_NUM, TYPE_RESPONSE, callback);
  }

  public Observable<ItunesRes> rxRequestAppsList(){
    return itunesApi.requestAppsList(COUNTRY_US, TYPE_CALL, LIMIT_NUM, TYPE_RESPONSE);
  }
}
