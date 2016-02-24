package com.fabiel.applist.modules.app_gallery;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

import com.fabiel.applist.R;
import com.fabiel.applist.modules.app_gallery.adapter.GalleryAdapter;
import com.fabiel.applist.modules.apps_list.AppsListFragment;
import com.fabiel.applist.modules.detail.AppDetailActivity;
import com.fabiel.applist.modules.main.CategoryFragment;
import com.fabiel.applist.storage.RealmManager;
import com.fabiel.applist.storage.models.AppItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppGalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppGalleryFragment extends Fragment {
  @Bind(R.id.gridLayoutGallery)
  GridView gridLayoutGallery;

  private RealmResults<AppItem> appList;

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param bundle Parameters.
   * @return A new instance of fragment AppGalleryFragment.
   */
  public static AppGalleryFragment newInstance(Bundle bundle) {
    AppGalleryFragment fragment = new AppGalleryFragment();
    fragment.setArguments(bundle);
    return fragment;
  }

  public AppGalleryFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      String categoryId = getArguments().getString(CategoryFragment.CATEGORY_ID);
      appList = RealmManager.sharedInstance().appItem().getAppLocalListByCategory(categoryId);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_app_gallery, container, false);
    ButterKnife.bind(this, rootView);
    if(appList != null && !appList.isEmpty()){
      populateAdapter();
    }
    return rootView;
  }

  private void populateAdapter() {
    GalleryAdapter galleryAdapter = new GalleryAdapter(getActivity(), appList);
    gridLayoutGallery.setAdapter(galleryAdapter);
    gridLayoutGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AppItem appItem = appList.get(position);
        Intent intent = new Intent(getActivity(), AppDetailActivity.class);
        intent.putExtra(AppsListFragment.APPITEM_ID, appItem.getId());
        startActivity(intent);
      }
    });
  }

}
