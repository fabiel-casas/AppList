package com.fabiel.applist.app;

import android.app.Application;
import android.graphics.Bitmap;

import com.fabiel.applist.storage.RealmManager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.io.File;

/**
 * Created by JohanFabiel on 20/02/2016.
 */
public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    RealmManager.init(this);
    DisplayImageOptions options = new DisplayImageOptions.Builder()
        .cacheInMemory(false) // default
        .cacheOnDisc(true) // default
        .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
        .bitmapConfig(Bitmap.Config.ARGB_8888) // default
        .build();

    // Create global configuration and initialize ImageLoader with this configuration
    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
        .defaultDisplayImageOptions(options)
        .build();

    ImageLoader.getInstance().init(config);
  }
}
