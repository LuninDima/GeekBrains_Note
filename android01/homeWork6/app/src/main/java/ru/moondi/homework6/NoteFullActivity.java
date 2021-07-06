package ru.moondi.homework6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class NoteFullActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_full);
       boolean isOrientation = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if(isOrientation){
            finish();
            return;
        }
        if(savedInstanceState == null){
            NoteFullFragment fullFragment = new NoteFullFragment();
            fullFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fullFragment).commit();

        }
    }
}