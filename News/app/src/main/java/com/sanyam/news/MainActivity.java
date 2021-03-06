package com.sanyam.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                android.app.FragmentManager manager = getFragmentManager();
                switch (tab.getPosition()) {
                    case 0:
                        android.app.FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.framelayout, new fragment_1());
                        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        transaction.commit();
                        break;
                    case 1:
                        android.app.FragmentTransaction transaction2 = manager.beginTransaction();
                        transaction2.replace(R.id.framelayout, new fragment_2());
                        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        transaction2.commit();
                        break;
                    case R.id.tab3:
                        android.app.FragmentTransaction transaction3 = manager.beginTransaction();
                        transaction3.replace(R.id.framelayout, new fragment_3());
                        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        transaction3.commit();
                        break;
                    case R.id.tab4:
                        android.app.FragmentTransaction transaction4 = manager.beginTransaction();
                        transaction4.replace(R.id.framelayout, new fragment_4());
                        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        transaction4.commit();
                        break;
                    case R.id.tab5:
                        android.app.FragmentTransaction transaction5 = manager.beginTransaction();
                        transaction5.replace(R.id.framelayout, new fragment_5());
                        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        transaction5.commit();
                        break;
                    case R.id.tab6:
                        android.app.FragmentTransaction transaction6 = manager.beginTransaction();
                        transaction6.replace(R.id.framelayout, new fragment_6());
                        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        transaction6.commit();
                        break;
                    case R.id.tab7:
                        android.app.FragmentTransaction transaction7 = manager.beginTransaction();
                        transaction7.replace(R.id.framelayout, new fragment_7());
                        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        transaction7.commit();
                        break;
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            ;

        })
        ;
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
        if (id == R.id.signout) {
            auth.signOut();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.favourites) {
            // Handle the camera action
        } else if (id == R.id.world) {

        } else if (id == R.id.national) {

        } else if (id == R.id.business) {

        } else if (id == R.id.sport) {

        } else if (id == R.id.entertainment) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

}
