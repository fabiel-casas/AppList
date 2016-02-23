package com.fabiel.applist.modules.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.fabiel.applist.storage.models.AppCategory;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by JohanFabiel on 22/02/2016.
 */
public class CategoryAdapter extends RealmBaseAdapter<AppCategory> {

  public CategoryAdapter(Context context, RealmResults<AppCategory> realmResults, boolean automaticUpdate) {
    super(context, realmResults, automaticUpdate);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      convertView = inflater.inflate(android.R.layout.simple_list_item_1,
          parent, false);
      viewHolder = new ViewHolder();
      viewHolder.categoryName = (TextView) convertView.findViewById(android.R.id.text1);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }

    AppCategory item = realmResults.get(position);
    viewHolder.categoryName.setText(item.getName());
    return convertView;
  }

  private static class ViewHolder{
    TextView categoryName;
  }
}
