package com.example.khalid.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Communicator {

   // ViewPager viewPager;
   // CustomSwipeAdapter imgadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityListFragment mainActivityListFragment = new MainActivityListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_main, mainActivityListFragment,
                mainActivityListFragment.getTag()).commit();



       // viewPager = (ViewPager) findViewById(R.id.viewpager1);
       // imgadapter = new CustomSwipeAdapter(this);
       // viewPager.setAdapter(imgadapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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


  /*  @Override
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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            MainActivityListFragment mainActivityListFragment = new MainActivityListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, mainActivityListFragment, mainActivityListFragment.getTag()).commit();
            setTitle("ThimarAljazirah");
        } else if (id == R.id.nav_notification) {

            NotificationsFragment notificationsFragment = new NotificationsFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, notificationsFragment, notificationsFragment.getTag()).commit();
            setTitle("Notifications");

        } else if (id == R.id.nav_messages) {

        } else if (id == R.id.nav_categories) {

        } else if (id == R.id.nav_deals) {

        } else if (id == R.id.nav_settings) {

            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);

            //SettingFragment settingFragment = new SettingFragment();
            //FragmentManager fragmentManager = getSupportFragmentManager();
            //fragmentManager.beginTransaction().replace(R.id.content_main, settingFragment, settingFragment.getTag()).commit();
        } else if (id == R.id.nav_help_contact) {

        } else if (id == R.id.nav_profile) {
            MyProfile myProfile = new MyProfile();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, myProfile, myProfile.getTag()).commit();
            setTitle("My Profile");

        } else if (id == R.id.nav_signout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_about_us) {
            AboutUsFragment aboutUsFragment = new AboutUsFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main,aboutUsFragment, aboutUsFragment.getTag()).commit();
            setTitle("About Thimar Aljazirah");
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void respond(int position) {
    }
}
