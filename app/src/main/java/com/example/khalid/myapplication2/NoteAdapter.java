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

public class NoteAdapter extends ArrayAdapter<Note>{

    public static class ViewHolder{
        TextView title;
        ImageView noteIcon;
    }

    public NoteAdapter(Context context, ArrayList<Note> notes){
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        // Get the date item for this position
        Note note = getItem(position);

        // Create a new ViewHolder
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate a new view from custom row layout
        if(convertView == null){

            // If we don't have a view that being used create one, and make sure you create a
            // ViewHolder along with it to save our view references to.
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.general_cate_row_list, parent, false);

            viewHolder.title = (TextView) convertView.findViewById(R.id.listItemNoteTitle);
            viewHolder.noteIcon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

            // Use set tag to rmember our view holder which is holding our references to our widgets
            convertView.setTag(viewHolder);
        }else {

            // We already have a view so just go to our view holder and grab the widgets from it.
            viewHolder = (ViewHolder) convertView.getTag();
        }


        // Populate the data into the template view using the data object
        viewHolder.title.setText(note.getTitle());
        viewHolder.noteIcon.setImageResource(note.getAssDrable());

        return convertView;
    }
}
