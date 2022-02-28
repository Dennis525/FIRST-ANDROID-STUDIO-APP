package com.example.effill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class Navigation_main extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout,R.string.menu_Open,R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        Log.i("menu_drawer_tag","home item is selected");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_search:
                        Log.i("menu_drawer_tag","search item is selected");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_user:
                        Log.i("menu_drawer_Tag","user item is selected");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_share:
                        Log.i("menu_drawer_tag","share item selected");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_logout:
                        Log.i("menu_drawer_tag","log out item selected");
                        break;
                }


                return true;
            }
        });



    }
}