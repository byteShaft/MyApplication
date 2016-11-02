package com.example.khalid.myapplication2;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        notes = new ArrayList<>();
        notes.add(new Note("HEALTH CARE", Note.Category.HEALTHCARE));
        notes.add(new Note("DENTAL", Note.Category.DENTAL));
        notes.add(new Note("CARDIAC", Note.Category.CARDIAC));
        notes.add(new Note("RESPIRATORY", Note.Category.RESPIRATORY));
        notes.add(new Note("PHARMACEUTICALS", Note.Category.PHARMA));
        noteAdapter = new NoteAdapter(getActivity(), notes);
        setListAdapter(noteAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
       launchNoteDetailActivity(position);
    }

    private void launchNoteDetailActivity(int position){
            SecondActivityListFragment secondActivityListFragment = new SecondActivityListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_main, secondActivityListFragment,
                secondActivityListFragment.getTag()).commit();
    }
}
