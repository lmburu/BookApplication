package com.sivector.android.bookapplication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BookListFragment extends Fragment {


    private RecyclerView mBookRecyclerView;
    private BookAdapter mBookAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booklist, container, false);
        mBookRecyclerView = view.findViewById(R.id.bookRecyclerView);
        mBookRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        updateUI();
        return view;
    }

    public void updateUI(){
        mBookAdapter = new BookAdapter();
        mBookRecyclerView.setAdapter(mBookAdapter);
    }

    private class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Book mBook;
        private TextView mAuthorTextView;
        private TextView mTitleTextView;

        public BookViewHolder(View itemView){
            super(itemView);
            mAuthorTextView = itemView.findViewById(R.id.author);
            mTitleTextView  = itemView.findViewById(R.id.booktitle);
            itemView.setOnClickListener(this);

        }

        public void setBookView( Book book ){
            mBook = book;
            mAuthorTextView.setText(mBook.getAuthor());
            mTitleTextView.setText(mBook.getTitle());
        }


        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(), "open other fragment", Toast.LENGTH_SHORT).show();
        }
    }

    private class BookAdapter extends RecyclerView.Adapter<BookViewHolder>{

        List<Book> mBookList;

        public BookAdapter(){
            mBookList = BookLibrary.getInstance().getBooks();
        }
        @NonNull
        @Override
        public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view  = layoutInflater.inflate(R.layout.book_details, parent, false);
            return new BookViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
            Book book = mBookList.get(position);
            holder.setBookView(book);
        }

        @Override
        public int getItemCount() {
            return mBookList.size();
        }
    }
}
