package ru.moondi.homework6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import static ru.moondi.homework6.NoteFullFragment.ARG_NOTE;

public class MainActivity extends AppCompatActivity {
    public static final String CURRENT_NOTE = "CurrentNote";
    public Note currentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savedInstanceState(savedInstanceState);
         initToolbar();
        initButton();
        addFragment(new NoteListFragment());

    }

    private void savedInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // Восстановление текущей позиции.
            currentNote = savedInstanceState.getParcelable(CURRENT_NOTE);
        } else {
            String[] noteName = getResources().getStringArray(R.array.noteName);
            String[] noteDescription = getResources().getStringArray(R.array.noteDescription);
            String[] noteDate = getResources().getStringArray(R.array.noteDate);
            String[] noteText = getResources().getStringArray(R.array.noteText);
            currentNote = new Note(noteName[0],noteDescription[0], noteDate[0],noteText[0], 0);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(CURRENT_NOTE, currentNote);
        super.onSaveInstanceState(outState);
    }


    private void initButton() {
        Button buttonFullFragmentContentMain = findViewById(R.id.button_full_fragment_content_main);
        Button buttonListFragmentContentMain = findViewById(R.id.button_list_fragment_main_content);
        buttonFullFragmentContentMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mylogs", "полная");
                if (currentNote != null) { // если у нас уже выбрана заметка, и нам есть что показать
                    addFragment(NoteFullFragment.newInstance(currentNote));
                } else { // если нечего показать(не выбрана заметка), предупреждаем пользователя
                    Toast.makeText(getApplicationContext(), "Не выбрана ни одна заметка", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonListFragmentContentMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mylogs", "список");
                addFragment(new NoteListFragment());
            }
        });
    }

    private void addFragment(Fragment fragment) {
        Log.d("mylogs", "добавить фрагмент");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_main, fragment);
        fragmentTransaction.commit();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

           @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "Настройки", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_main:
                Toast.makeText(MainActivity.this, "Главная", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_favorite:
                Toast.makeText(MainActivity.this, "Избранное", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                Toast.makeText(MainActivity.this, "Поиск", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchText = (SearchView) search.getActionView();
        searchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return true;
            }

             @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }


        });
        return true;
    }
}