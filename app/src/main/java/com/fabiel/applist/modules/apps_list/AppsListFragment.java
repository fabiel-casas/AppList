package com.fabiel.applist.modules.apps_list;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fabiel.applist.R;
import com.fabiel.applist.modules.apps_list.adapter.AppListAdapter;
import com.fabiel.applist.modules.detail.AppDetailActivity;
import com.fabiel.applist.modules.main.CategoryFragment;
import com.fabiel.applist.storage.RealmManager;
import com.fabiel.applist.storage.models.AppItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * A placeholder fragment containing a simple view.
 */
public class AppsListFragment extends Fragment {

  @Bind(R.id.listViewApps)
  ListView listViewApps;
  private RealmResults<AppItem> appList;
  public static String APPITEM_ID = "appItem_id";

  public AppsListFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_apps_list, container, false);
    ButterKnife.bind(this, rootView);
    String categoryId = getArguments().getString(CategoryFragment.CATEGORY_ID);
    appList = RealmManager.sharedInstance().appItem().getAppLocalListByCategory(categoryId);
    populateAdapter();
    return rootView;
  }

  private void populateAdapter() {
    AppListAdapter appListAdapter = new AppListAdapter(getActivity(), appList, true);
    listViewApps.setAdapter(appListAdapter);
    listViewApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AppItem appItem = appList.get(position);
        Intent intent = new Intent(getActivity(), AppDetailActivity.class);
        intent.putExtra(APPITEM_ID, appItem.getId());
        startActivity(intent);
      }
    });
  }

  public static AppsListFragment newInstance(Bundle bundle) {
    AppsListFragment appsListFragment = new AppsListFragment();
    appsListFragment.setArguments(bundle);
    return appsListFragment;
  }
}
