package com.fabiel.applist.modules.main;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fabiel.applist.R;
import com.fabiel.applist.api.ItunesServiceManager;
import com.fabiel.applist.api.models.ItunesRes;
import com.fabiel.applist.modules.main.adapter.CategoryAdapter;
import com.fabiel.applist.storage.RealmManager;
import com.fabiel.applist.storage.models.AppCategory;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
  @Bind(R.id.listViewCategories)
  ListView listViewCategories;
  private RealmResults<AppCategory> appCategories;

  public static String CATEGORY_ID = "categoryId";

  public interface CategoryEventListener{
    void OnCategorySelected(String categoryId);
  }

  private CategoryEventListener callback;

  public void setCategoryEventCallback(CategoryEventListener callback) {
    this.callback = callback;
  }

  public static CategoryFragment newInstance() {
    CategoryFragment fragment = new CategoryFragment();
    return fragment;
  }

  public CategoryFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);
    ButterKnife.bind(this, rootView);
    populateFragmentData();
    return rootView;
  }

  private void populateFragmentData() {
    appCategories = RealmManager.sharedInstance().appItem().getCategoryList();
    if(appCategories == null || appCategories.isEmpty()) {
      new ItunesServiceManager().getListOfApp().subscribe(new Subscriber<ItunesRes>() {
        @Override
        public void onCompleted() {
          Log.d("Results", "Complete ");
          appCategories = RealmManager.sharedInstance().appItem().getCategoryList();
          populateAdapters();
        }

        @Override
        public void onError(Throwable e) {
          Log.d("Results", "Error " + e.getMessage());
        }

        @Override
        public void onNext(ItunesRes itunesRes) {
          RealmManager.sharedInstance().appItem().createAppItems(itunesRes.getFeed().getEntry());
        }
      });
    } else {
      Log.d("Results", "Datos en local storage");
      populateAdapters();
    }
  }

  private void populateAdapters() {
    Log.d("Results", "Results num = " + appCategories.size());
    CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), appCategories, true);
    listViewCategories.setAdapter(categoryAdapter);
    listViewCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AppCategory appCategory = appCategories.get(position);
        if(callback != null){
          callback.OnCategorySelected(appCategory.getId());
        }
      }
    });
  }
}
