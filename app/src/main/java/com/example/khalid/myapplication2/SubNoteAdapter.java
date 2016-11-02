package com.example.khalid.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by khalid on 2016-09-30.
 */

public class SubNoteAdapter extends ArrayAdapter<SubNote>{

    private static class ViewHolder{
        TextView name, briefDescription, price;
        ImageView noteIcon;
    }

    public SubNoteAdapter(Context context, ArrayList<SubNote> subNotes){
        super(context, 0, subNotes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Get the date item for this position
        SubNote SubNote = getItem(position);

        // Create a new ViewHolder
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate a new view from custom row layout
        if(convertView == null){
            // If we don't have a view that being used create one, and make sure you create a
            // ViewHolder along with it to save our view references to.
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.specific_cate_row_list, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.specific_list_Item_name);
            viewHolder.briefDescription = (TextView) convertView.findViewById(R.id.specific_item_briefDescription);
            viewHolder.price = (TextView) convertView.findViewById(R.id.specific_item_price);
            viewHolder.noteIcon = (ImageView) convertView.findViewById(R.id.specific_list_Item_Img);

            // Use set tag to rmember our view holder which is holding our references to our widgets
            convertView.setTag(viewHolder);
        }else {

            // We already have a view so just go to our view holder and grab the widgets from it.
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.name.setText(SubNote.getTitle());
        viewHolder.briefDescription.setText(SubNote.getBriefDescription());
        viewHolder.price.setText("" + SubNote.getPrice());
        viewHolder.noteIcon.setImageResource(SubNote.getProductImages()[0]);
        return convertView;
    }
}
