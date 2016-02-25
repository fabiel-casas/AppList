package com.fabiel.applist.modules;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fabiel.applist.R;
import com.fabiel.applist.modules.app_gallery.AppGalleryFragment;
import com.fabiel.applist.modules.apps_list.AppsListActivity;
import com.fabiel.applist.modules.main.CategoryFragment;


public class MainActivity extends AppCompatActivity implements CategoryFragment.CategoryEventListener {

  private boolean twoPanels = false;
  private String categoryId= "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if(findViewById(R.id.frameLayoutContainer) != null){
      twoPanels = true;
      if(savedInstanceState == null) {
        Bundle bundle = new Bundle();
        bundle.putString(CategoryFragment.CATEGORY_ID, categoryId);
        getFragmentManager()
            .beginTransaction()
            .setCustomAnimations(
                R.animator.card_flip_right_in,
                R.animator.card_flip_right_out,
                R.animator.card_flip_left_in,
                R.animator.card_flip_left_out)
            .replace(R.id.frameLayoutContainer, AppGalleryFragment.newInstance(bundle), null)
            .commit();
      }
      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    } else {
      twoPanels = false;
      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    CategoryFragment categoryFragment = (CategoryFragment) getFragmentManager().findFragmentById(R.id.fragment_categories);
    if(categoryFragment != null){
      categoryFragment.setCategoryEventCallback(this);
    }
  }


  @Override
  public void OnCategorySelected(String categoryId) {
    this.categoryId = categoryId;
    if(twoPanels){
      Bundle bundle = new Bundle();
      bundle.putString(CategoryFragment.CATEGORY_ID, categoryId);
      getFragmentManager()
          .beginTransaction()
          .setCustomAnimations(
              R.animator.card_flip_right_in,
              R.animator.card_flip_right_out,
              R.animator.card_flip_left_in,
              R.animator.card_flip_left_out)
          .replace(R.id.frameLayoutContainer, AppGalleryFragment.newInstance(bundle), null)
          .commit();
    } else {
      Intent intent = new Intent(getApplicationContext(), AppsListActivity.class);
      intent.putExtra(CategoryFragment.CATEGORY_ID, categoryId);
      startActivity(intent);
      overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }
  }
}