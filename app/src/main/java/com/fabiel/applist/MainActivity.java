package com.fabiel.applist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fabiel.applist.modules.apps_list.AppsListActivity;
import com.fabiel.applist.modules.main.CategoryFragment;


public class MainActivity extends AppCompatActivity implements CategoryFragment.CategoryEventListener {

  private boolean twoPanels = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    CategoryFragment categoryFragment = (CategoryFragment) getFragmentManager().findFragmentById(R.id.fragment_categories);
    if(categoryFragment != null){
      categoryFragment.setCategoryEventCallback(this);
    }
  }


  @Override
  public void OnCategorySelected(String categoryId) {
    if(twoPanels){

    } else {
      Intent intent = new Intent(getApplicationContext(), AppsListActivity.class);
      intent.putExtra(CategoryFragment.CATEGORY_ID, categoryId);
      startActivity(intent);
    }
  }
}