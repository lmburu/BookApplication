package com.sivector.android.bookapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if ( supportFragmentManager.findFragmentById(R.id.fragment_container) == null ) {
            BookFragment bookFragment = new BookFragment();
            //BookListFragment bookListFragment = new BookListFragment();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, bookFragment);
            fragmentTransaction.commit();
        }
    }
}
