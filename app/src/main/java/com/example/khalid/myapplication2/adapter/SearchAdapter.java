package com.example.khalid.myapplication2.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.khalid.myapplication2.R;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class SearchAdapter extends ArrayAdapter<String> {

    private final Activity activity;
    private final ArrayList searchResult;
    private ViewHolder viewHolder;

    public SearchAdapter(Activity activity, ArrayList searchResule) {
        super(activity, R.layout.delegate_search, searchResule);
        this.activity = activity;
        this.searchResult = searchResule;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.delegate_search, parent, false);
            viewHolder.nameTitle = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (searchResult.size() > position) {
            viewHolder.nameTitle.setText((String) searchResult.get(position));
        }
        return convertView;
    }

    private class ViewHolder {
        TextView nameTitle;
    }
}
