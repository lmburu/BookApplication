package com.sivector.android.bookapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookLibrary {
    private static BookLibrary mBookLibrary;

    private List<Book> mBooks;

    private BookLibrary() {
        this.mBooks = new ArrayList<>();
        bookGenerator(); // Dummy data for testing.
    }

    public static BookLibrary getInstance(){
        if(mBookLibrary == null ) {
            mBookLibrary = new BookLibrary();
            return mBookLibrary;
        }
        return mBookLibrary;
    }

    public void addBook(Book book){
        if(book.getAuthor() != null ) {
            mBooks.add(book);
        }
    }

    public Book getBook(UUID id ){
        for(int i = 0; i < mBooks.size(); i++ ) {
            if ( mBooks.get(i).getId() == id ) {
                return mBooks.get(i);
            }
        }
        return null;
    }

    public List<Book> getBooks() {
        return mBooks;
    }

    private void bookGenerator(){
        for(int i = 0; i < 100; i++ ) {
            Book book = new Book();
            book.setAuthor("smith" + i );
            book.setTitle("Android Programming" + i );
            mBooks.add(book);
        }
    }
}
