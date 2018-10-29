package com.sivector.android.bookapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class BookActivity extends AppCompatActivity {

    public static final String EXTRA_BOOK_ID = "com.sivector.android.bookapplication.bookid";

    public static Intent newIntent(Context packageContext, UUID bookId){
        Intent intent = new Intent(packageContext, BookActivity.class);
        intent.putExtra(EXTRA_BOOK_ID, bookId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if ( supportFragmentManager.findFragmentById(R.id.fragment_container) == null ) {

            Bundle extras = getIntent().getExtras();
            UUID bookId = (UUID) extras.getSerializable(EXTRA_BOOK_ID);
            BookFragment bookFragment = BookFragment.newInstance(bookId);

            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, bookFragment);
            fragmentTransaction.commit();
        }
    }
}
