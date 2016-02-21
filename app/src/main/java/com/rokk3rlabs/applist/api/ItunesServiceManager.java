package com.rokk3rlabs.applist.api;

import com.rokk3rlabs.applist.api.models.AppInfo;
import com.rokk3rlabs.applist.api.models.ItunesRes;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class ItunesServiceManager {

  private ItunesService itunesService;

  public ItunesServiceManager() {
    this.itunesService = ItunesService.getInstance();
  }

  public Observable<ItunesRes> getListOfApp(){
    return itunesService.rxRequestAppsList()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public interface AppListListener{
    void OnAppListReady(List<AppInfo> appInfoList);
  }

  private AppListListener appListListener;
}
