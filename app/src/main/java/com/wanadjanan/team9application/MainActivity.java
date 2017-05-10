package com.wanadjanan.team9application;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_57160387) {
            Intent load = new Intent(getApplicationContext(),Activity57160387.class);
            startActivity(load);

        } else if (id == R.id.nav_57160016) {
            Intent load = new Intent(getApplicationContext(),Activity57160016.class);
            startActivity(load);
        } else if (id == R.id.nav_57160692) {
            Intent load = new Intent(getApplicationContext(),Activity57160692.class);
            startActivity(load);
        } else if (id == R.id.nav_57160142) {
            Intent load = new Intent(getApplicationContext(),Activity57160142.class);
            startActivity(load);
        } else if (id == R.id.nav_57160145) {
            Intent load = new Intent(getApplicationContext(),Activity57160145.class);
            startActivity(load);
        } else if (id == R.id.nav_57160017) {
            Intent load = new Intent(getApplicationContext(),Activity57160017.class);
            startActivity(load);
        } else if (id == R.id.nav_57160691) {
            Intent load = new Intent(getApplicationContext(),Activity57160691.class);
            startActivity(load);
        } else if (id == R.id.nav_57160159) {
            Intent load = new Intent(getApplicationContext(),Activity57160159.class);
            startActivity(load);
        } else if (id == R.id.nav_57160092) {
            Intent load = new Intent(getApplicationContext(),Activity57160092.class);
            startActivity(load);
        } else if (id == R.id.nav_57160136) {
            Intent load = new Intent(getApplicationContext(),Activity57160136.class);
            startActivity(load);
        } else if (id == R.id.nav_57160280) {
            Intent load = new Intent(getApplicationContext(),Activity57160280.class);
            startActivity(load);
        } else if (id == R.id.nav_57160074) {
            Intent load = new Intent(getApplicationContext(),Activity57160074.class);
            startActivity(load);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
