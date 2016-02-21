package com.rokk3rlabs.applist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rokk3rlabs.applist.api.ItunesServiceManager;
import com.rokk3rlabs.applist.api.models.ItunesRes;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.textViewIsDone)
  TextView textViewIsDone;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    new ItunesServiceManager().getListOfApp().subscribe(new Subscriber<ItunesRes>() {
      @Override
      public void onCompleted() {
        Log.d("Results", "Complete ");
      }

      @Override
      public void onError(Throwable e) {
        Log.d("Results", "Error " + e.getMessage());
      }

      @Override
      public void onNext(ItunesRes itunesRes) {
        Log.d("Results", "Results num = " + itunesRes.getFeed().getEntry().size());
        textViewIsDone.setText("Process is Done!!!");
      }
    });
  }
}
