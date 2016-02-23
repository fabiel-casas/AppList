package com.fabiel.applist.modules.apps_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fabiel.applist.R;

public class AppsListActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_apps_list);

    getFragmentManager().beginTransaction().replace(R.id.frameLayout_app_list_container, AppsListFragment.newInstance(getIntent().getExtras())).commit();
  }

}
