package com.fabiel.applist.modules.app_gallery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fabiel.applist.R;
import com.fabiel.applist.storage.models.AppItem;
import com.fabiel.applist.utils.StringUtilities;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by JohanFabiel on 23/02/2016.
 */
public class GalleryAdapter extends BaseAdapter {
  private Context mContext;
  private RealmResults<AppItem> appList;

  public GalleryAdapter(Context context, RealmResults<AppItem> appList) {
    this.mContext = context.getApplicationContext();
    this.appList = appList;
  }

  @Override
  public int getCount() {
    return appList.size();
  }

  @Override
  public Object getItem(int position) {
    return appList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_gallery, parent, false);
      viewHolder = new ViewHolder(convertView);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }

    AppItem item = appList.get(position);
    viewHolder.textViewAppName.setText(item.getName());
    viewHolder.textViewPrice.setText(StringUtilities.getPrice(item.getPrice()));
    ImageLoader.getInstance().displayImage(item.getImages().get(2).getUrlImage(), viewHolder.imageViewIconApp);
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
