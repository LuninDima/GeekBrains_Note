package ru.moondi.homework6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteFullFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class NoteFullFragment extends Fragment {
    public static final String ARG_INDEX = "index";
    private int index;

    public static NoteFullFragment newInstance(int index) {
        NoteFullFragment fragment = new NoteFullFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    public NoteFullFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
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
        String[] noteName = getResources().getStringArray(R.array.noteName);
        String[] noteDescription = getResources().getStringArray(R.array.noteDescription);
        String[] noteDate = getResources().getStringArray(R.array.noteDate);
        String[] noteText = getResources().getStringArray(R.array.noteText);
        noteTvName.setText(noteName[index]);
        noteTvDescription.setText(noteDescription[index]);
        noteTvDate.setText(noteDate[index]);
        noteTvText.setText(noteText[index]);
        return view;
    }

}