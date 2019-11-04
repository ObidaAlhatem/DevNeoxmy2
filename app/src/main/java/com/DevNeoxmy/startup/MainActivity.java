package com.DevNeoxmy.startup;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
//import com.google.firebase.auth.FirebaseAuth;
import java.io.File;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    //Add Navigation Drawer
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Add Navigation Drawer
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);



    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_newaccount) {

        } else if (id == R.id.nav_login) {

        } else if (id == R.id.nav_offers) {

            Intent it = new Intent(MainActivity.this, OurServicesActivity.class);
            startActivity(it);

        } else if (id == R.id.ListOfDeveloper) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            DeveloperListFragment fragmentList = new DeveloperListFragment();
            fragmentTransaction.replace(R.id.fragment_container, fragmentList).addToBackStack(null);
            fragmentTransaction.commit();

            //the user share our app
        }
        else if (id == R.id.nav_about) {
            Intent i= new Intent(MainActivity.this, About.class);
            startActivity(i);

        }  else if (id == R.id.nav_share) {

            ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String apkpath = api.sourceDir;
            Intent shrintent = new Intent(Intent.ACTION_SEND);
            shrintent.setType("application/vnd.android.package-archive");
            shrintent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
            startActivity(Intent.createChooser(shrintent, "Share Using"));


        // make the user rate the app in google play
        } else if (id == R.id.nav_rate) {

            Intent rateintent = new Intent(Intent.ACTION_VIEW);
            rateintent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.DevNeoxmy.startup"));

            startActivity(rateintent);

        } else if (id == R.id.SignOut) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(getString(R.string.exit));
            builder.setMessage(getString(R.string.signoutmessage));
            builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //FirebaseAuth.getInstance().signOut();
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
            });
            builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
