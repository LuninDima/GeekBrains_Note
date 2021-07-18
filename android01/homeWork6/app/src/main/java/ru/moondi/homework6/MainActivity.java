package ru.moondi.homework6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String CURRENT_NOTE = "CurrentNote";
    public Note currentNote;
    private boolean isLandScape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savedInstanceState(savedInstanceState);
        Toolbar toolbar = initToolbar();
        initDrawer(toolbar);
        initView();


    }

    private void initView() {
        isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (!isLandScape) {
            initButton();
            addFragment(new NoteListFragment());
        }

    }

    private void initDrawer(Toolbar toolbar) {
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Обработка навигационного меню
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (navigateFragment(id)) {
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
                return false;
            }
        });
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
            currentNote = new Note(noteName[0], noteDescription[0], noteDate[0], noteText[0], 0);
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
        if (isLandScape) {
            fragmentTransaction.replace(R.id.NoteFullFragment, fragment);
        } else fragmentTransaction.replace(R.id.fragment_container_main, fragment);
        fragmentTransaction.commit();
    }

    private Toolbar initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
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

    private boolean navigateFragment(int id) {
        switch (id) {

            case R.id.notes_item_menu_drawer:
                if (!isLandScape) {
                    addFragment(new NoteListFragment());
                    return true;
                }
            case R.id.full_note_item_menu_drawer:
                if (!isLandScape) {
                    if (currentNote != null) {
                        addFragment(NoteFullFragment.newInstance(currentNote));
                    } else {
                        Toast.makeText(getApplicationContext(), "Не выбрана ни одна заметка", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            case R.id.settings_item_menu_drawer:
                Toast.makeText(getApplicationContext(), "Настройки", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about_item_menu_drawer:
                addFragment(new AboutFragment());
                return true;
        }
        return false;
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