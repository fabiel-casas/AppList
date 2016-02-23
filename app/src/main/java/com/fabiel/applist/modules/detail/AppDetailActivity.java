package com.fabiel.applist.modules.detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fabiel.applist.R;

public class AppDetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_app_detail);
    getFragmentManager()
        .beginTransaction()
        .replace(R.id.frameLayout_app_detail_container, AppDetailFragment.newInstance(getIntent().getExtras()))
        .commit();
  }

}
