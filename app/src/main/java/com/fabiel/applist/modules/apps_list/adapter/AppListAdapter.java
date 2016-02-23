package com.fabiel.applist.modules.apps_list.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fabiel.applist.R;
import com.fabiel.applist.storage.models.AppItem;
import com.fabiel.applist.utils.StringUtilities;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by JohanFabiel on 22/02/2016.
 */
public class AppListAdapter extends RealmBaseAdapter<AppItem> {
  public AppListAdapter(Context context, RealmResults<AppItem> realmResults, boolean automaticUpdate) {
    super(context, realmResults, automaticUpdate);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      convertView = inflater.inflate(R.layout.adapter_app_list,
          parent, false);
      viewHolder = new ViewHolder(convertView);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }

    AppItem item = realmResults.get(position);
    viewHolder.textViewAppName.setText(item.getName());
    viewHolder.textViewPrice.setText(StringUtilities.getPrice(item.getPrice()));
    ImageLoader.getInstance().displayImage(item.getImages().get(1).getUrlImage(), viewHolder.imageViewIconApp);
    return convertView;
  }



  public static class ViewHolder{
    @Bind(R.id.textViewAppName)
    TextView textViewAppName;
    @Bind(R.id.textViewPrice)
    TextView textViewPrice;
    @Bind(R.id.imageViewIconApp)
    ImageView imageViewIconApp;

    public ViewHolder(View view) {
      ButterKnife.bind(this, view);
    }
  }
}
