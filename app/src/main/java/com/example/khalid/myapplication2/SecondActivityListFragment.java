package com.example.khalid.myapplication2;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondActivityListFragment extends ListFragment {

    Communicator communicator;
    private ArrayList<SubNote> subNotes;
    private SubNoteAdapter subNoteAdapter;
    private int[] productImages = {R.drawable.defualt_img, R.drawable.ad2, R.drawable.ad3};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ///https://www.youtube.com/watch?v=5v_1cqkFSuQ
        ///https://coursetro.com/courses/2/Design-+-Code-an-Android-App-from-Scratch/lessons/60
        subNotes = new ArrayList<>();
        subNotes.add(new SubNote("Death Wish Coffee", "Worlds Strongest Coffee",
                "The World's Strongest Coffee in a one pound bag. These beans have been carefully " +
                        "selected and roasted to perfection in order to provide a bold yet smooth " +
                        "cup of coffee with an extra kick of caffeine that is sure to get your day " +
                        "going.", new BigDecimal(69.56).setScale(2, BigDecimal.ROUND_FLOOR), productImages));
        subNotes.add(new SubNote("Product Y", "wow", "booo", new BigDecimal(10.23).setScale(2,
                BigDecimal.ROUND_FLOOR), productImages));
        subNoteAdapter = new SubNoteAdapter(getActivity(), subNotes);
        setListAdapter(subNoteAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        ItemViewFragment itemViewFragment = new ItemViewFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("key", position);
        bundle.putString("name", subNotes.get(position).getTitle());
        bundle.putString("brief", subNotes.get(position).getBriefDescription());
        bundle.putString("full", subNotes.get(position).getFullDescription());
        bundle.putString("price", subNotes.get(position).getPrice().toString());
        bundle.putIntArray("images", subNotes.get(position).getProductImages());
        itemViewFragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_main, itemViewFragment,
                itemViewFragment.getTag()).commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Communicator) {
            communicator = (Communicator) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Communicator");
        }
    }

    //private void launchNoteDetailActivity(int position){
        // Grab the note information associated with whatever note item we clicked on
        // SubNote subNote = (SubNote) getListAdapter().getItem(position);

    //}
}
