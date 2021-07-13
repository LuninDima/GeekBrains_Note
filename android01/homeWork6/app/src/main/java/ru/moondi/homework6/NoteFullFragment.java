package ru.moondi.homework6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NoteFullFragment extends Fragment {
    public static final String ARG_NOTE = "note";
    public Note note;

    public static NoteFullFragment newInstance(Note note) {
        NoteFullFragment fragment = new NoteFullFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_full, container, false);
        TextView noteTvName = view.findViewById(R.id.note_tv_Name);
        TextView noteTvDescription = view.findViewById(R.id.note_tv_Description);
        TextView noteTvDate = view.findViewById(R.id.note_tv_Date);
        TextView noteTvText = view.findViewById(R.id.note_tv_text);
        noteTvName.setText(note.getNoteName());
        noteTvDescription.setText(note.getNoteDescription());
        noteTvDate.setText(note.getNoteDate());
        noteTvText.setText(note.getNoteText());
        return view;
    }

}