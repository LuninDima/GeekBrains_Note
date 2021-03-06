package ru.moondi.homework6;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class NoteListFragment extends Fragment {
    public static final String CURRENT_NOTE_KEY = "CURRENT_NOTE";
    private Note currentNote;
    private boolean isLandscape;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
        String[] noteListName = getResources().getStringArray(R.array.noteName);
        for (int i = 0; i < noteListName.length; i++) {
            TextView tvText = new TextView(getContext());
            tvText.setText(noteListName[i]);
            tvText.setTextSize(30);
            linearLayoutCompat.addView(tvText);
            final int fi = i;
            tvText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentNote = new Note(getResources().getStringArray(R.array.noteName)[fi], getResources().getStringArray(R.array.noteDescription)[fi], getResources().getStringArray(R.array.noteDate)[fi], getResources().getStringArray(R.array.noteText)[fi], fi);
                    showNoteFull(currentNote);

                }
            });
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(CURRENT_NOTE_KEY, currentNote);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (savedInstanceState != null) {
            currentNote = savedInstanceState.getParcelable(CURRENT_NOTE_KEY);
        } else {
            currentNote = new Note(getResources().getStringArray(R.array.noteName)[0], getResources().getStringArray(R.array.noteDescription)[0], getResources().getStringArray(R.array.noteDate)[0], getResources().getStringArray(R.array.noteText)[0], 0);
        }
        if(isLandscape){
            showLandNoteFull(currentNote);
        }
    }



private void showNoteFull(Note currentNote){
        isLandscape=getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE;
        if(isLandscape){
        showLandNoteFull(currentNote);
        }else showPortNoteFull(currentNote);
        }

private void showLandNoteFull(Note currentNote){
        NoteFullFragment fullFragment = NoteFullFragment.newInstance(currentNote);
        FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.NoteFullFragment, fullFragment);
        fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
        }

private void showPortNoteFull(Note currentNote){
        Intent intent=new Intent();
        intent.setClass(getActivity(),NoteFullActivity.class);
        intent.putExtra(NoteFullFragment.ARG_NOTE,currentNote);
        startActivity(intent);
        }
        }