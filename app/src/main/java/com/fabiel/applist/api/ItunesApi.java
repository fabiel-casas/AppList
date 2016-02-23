package com.fabiel.applist.api;

import com.fabiel.applist.api.models.ItunesRes;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public interface ItunesApi {

  @GET("/{country}/rss/{type_call}/{num_limit}/{type_response}")
  Observable<ItunesRes> requestAppsList(@Path("country") String country,
                       @Path("type_call") String type_call,
                       @Path("num_limit") String num_limit,
                       @Path("type_response") String type_response);
}
