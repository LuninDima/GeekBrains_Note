package ru.moondi.homework6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class NoteListFragment extends Fragment {


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
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat)view;
        String[] noteListName = getResources().getStringArray(R.array.noteName);
        for (int i = 0; i < noteListName.length; i++) {
            TextView tvText = new TextView(getContext());
            tvText.setText(noteListName[i]);
            tvText.setTextSize(30);
            linearLayoutCompat.addView(tvText);
            final int fi = i;
            tvText.setOnClickListener(v -> showPortNoteFull(fi));
        }
    }

    private void showPortNoteFull(int index) {
    Intent intent = new Intent();
    intent.setClass(getActivity(), NoteFullActivity.class);
    intent.putExtra(NoteFullFragment.ARG_INDEX, index);
    startActivity(intent);
    }
}