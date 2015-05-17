package com.nashvail.projectdemeter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // We will be rather replacing it with a fragment
        super.onCreate(savedInstanceState);

        FragmentManager fm = getSupportFragmentManager();
        Fragment mainFragment = fm.findFragmentById(R.id.container_fragment);

        // Adds the mainFragment to the fragmentContainer
        if(mainFragment == null) {
            mainFragment = new MainFragment();
            fm.beginTransaction().add(R.id.container_fragment, mainFragment).commit();
        }

    }
}
