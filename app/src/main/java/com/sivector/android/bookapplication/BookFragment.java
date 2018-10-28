package com.sivector.android.bookapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class BookFragment extends Fragment {

    private static final String DIALOG_DATE = "DialogDate";
    private static final int REQUEST_DATE = 0;

    private Book mBook;
    private EditText mAuthorNameEditText;
    private EditText mBookTitleEditText;
    private Button mDateOfPublicationButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBook = new Book();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        mAuthorNameEditText = view.findViewById(R.id.authorNameEditText);
        mBookTitleEditText  = view.findViewById(R.id.bookTitleEditText);
        mDateOfPublicationButton = view.findViewById(R.id.publicationDate);

        mBook.setAuthor(mAuthorNameEditText.getText().toString());
        mBook.setTitle(mBookTitleEditText.getText().toString());
        mBook.setPublicationDate(new Date());
        //TODO add reference to date button. convert to string maybe?

        mDateOfPublicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mBook.getPublicationDate());
                dialog.setTargetFragment(BookFragment.this, REQUEST_DATE);
                dialog.show(fragmentManager, DIALOG_DATE);
                Toast.makeText(getContext(), "Date goes here!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK) {
            return;
        }

        if(requestCode == REQUEST_DATE) {
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mBook.setPublicationDate(date);
            mDateOfPublicationButton.setText(mBook.getPublicationDate().toString());
        }
    }
}
