package com.sivector.android.bookapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class BookListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if ( supportFragmentManager.findFragmentById(R.id.container_fragment_book_list) == null ) {
            BookListFragment bookListFragment = new BookListFragment();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container_fragment_book_list, bookListFragment);
            fragmentTransaction.commit();
        }
    }

}
