package com.fabiel.applist.modules.detail;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fabiel.applist.R;
import com.fabiel.applist.modules.apps_list.AppsListFragment;
import com.fabiel.applist.storage.RealmManager;
import com.fabiel.applist.storage.models.AppItem;
import com.fabiel.applist.utils.StringUtilities;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class AppDetailFragment extends Fragment {
  @Bind(R.id.imageViewAppIcon)
  ImageView imageViewAppIcon;
  @Bind(R.id.textViewAppName)
  TextView textViewAppName;
  @Bind(R.id.textViewPrice)
  TextView textViewPrice;
  @Bind(R.id.textViewReleasedDate)
  TextView textViewReleasedDate;
  @Bind(R.id.textViewCategoryName)
  TextView textViewCategoryName;
  @Bind(R.id.textViewLink)
  TextView textViewLink;
  @Bind(R.id.textViewRights)
  TextView textViewRights;
  @Bind(R.id.textViewContentType)
  TextView textViewContentType;
  @Bind(R.id.textViewDescription)
  TextView textViewDescription;

  private AppItem appItem;

  public AppDetailFragment() {
  }
  public static AppDetailFragment newInstance(Bundle bundle) {
    AppDetailFragment appDetailFragment = new AppDetailFragment();
    appDetailFragment.setArguments(bundle);
    return appDetailFragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_app_detail, container, false);
    ButterKnife.bind(this, rootView);
    String appId = getArguments().getString(AppsListFragment.APPITEM_ID);
    appItem = RealmManager.sharedInstance().appItem().getAppItemById(appId);
    if(appItem != null){
      populateData();
    }
    return rootView;
  }

  private void populateData() {
    String imageUrl = appItem.getImages().get(2).getUrlImage();
    ImageLoader.getInstance().displayImage(imageUrl, imageViewAppIcon);

    textViewAppName.setText(appItem.getName());
    textViewPrice.setText(StringUtilities.getPrice(appItem.getPrice()));
    textViewReleasedDate.setText(appItem.getReleaseDate());
    textViewRights.setText(appItem.getRights());
    textViewCategoryName.setText(appItem.getCategory().getName());
    textViewLink.setText(appItem.getLink());
    textViewRights.setText(appItem.getRights());
    textViewContentType.setText(appItem.getContentType());
    textViewDescription.setText(appItem.getDescription());
  }


}
