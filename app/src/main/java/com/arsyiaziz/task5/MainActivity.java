package com.arsyiaziz.task5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.menu_item_computer,  new ComputerFragment());
        fragmentMap.put(R.id.menu_item_developer,  new DeveloperFragment());
        fragmentMap.put(R.id.menu_item_history,  new HistoryFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_item_computer);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = fragmentMap.get(item.getItemId());
        assert fragment != null;
        switch (item.getItemId()){
            case R.id.menu_item_computer:
                setActionBarTitle(getResources().getString(R.string.label_computers));
                break;
            case R.id.menu_item_developer:
                setActionBarTitle(getResources().getString(R.string.label_developers));
                break;
            case R.id.menu_item_history:
                setActionBarTitle(getResources().getString(R.string.label_history));
                break;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
        return true;
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}