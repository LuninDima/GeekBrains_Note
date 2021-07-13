package ru.moondi.homework6;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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
        initPopupMenu(view);

        return view;
    }

    private void initPopupMenu(View view) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = requireActivity();
                PopupMenu popupMenu = new PopupMenu(activity, v);
                activity.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                Menu menu = popupMenu.getMenu();
                menu.add(0, 123456, 12, R.string.add_menu_item);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.edit_item_poup:
                                Toast.makeText(getContext(), "Заметка отредактирована", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.del_item_popup:
                                Toast.makeText(getContext(), "Заметка удалена", Toast.LENGTH_SHORT).show();
                                return true;
                            case 123456:
                                Toast.makeText(getContext(), "Chosen new item added", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

    }


}