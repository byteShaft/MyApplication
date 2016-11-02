package com.example.khalid.myapplication2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemViewFragment extends Fragment {

    private ArrayList<SubNote> subNotes;

    public ItemViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int receivedPosition = getArguments().getInt("key");
        int [] receivedProductImages = getArguments().getIntArray("images");
        String receivedName = getArguments().getString("name");
        String receivedBriefDescription = getArguments().getString("brief");
        String receivedFullDescription = getArguments().getString("full");
        String receivedPrice = getArguments().getString("price");

        Log.i("ItemViewFragment", String.valueOf(receivedPosition));
        Log.i("ItemViewFragment", String.valueOf(receivedName));
        Log.i("ItemViewFragment", String.valueOf(receivedBriefDescription));
        Log.i("ItemViewFragment", String.valueOf(receivedFullDescription));
        Log.i("ItemViewFragment", String.valueOf(receivedPrice));

        View fragmentLayout = inflater.inflate(R.layout.fragment_item_view, container, false);
        TextView name = (TextView) fragmentLayout.findViewById(R.id.textView1);
        TextView briefDescription = (TextView) fragmentLayout.findViewById(R.id.textView2);
        TextView price = (TextView) fragmentLayout.findViewById(R.id.textView3);
        TextView fullDescription = (TextView) fragmentLayout.findViewById(R.id.full_item_description);
        ImageView icon = (ImageView) fragmentLayout.findViewById(R.id.viewpager2);

        name.setText(receivedName);
        briefDescription.setText(receivedBriefDescription);
        fullDescription.setText(receivedFullDescription);
        price.setText(receivedPrice);
        icon.setImageResource(receivedProductImages[0]);

        return fragmentLayout;
    }
}
