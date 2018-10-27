package com.sivector.android.bookapplication;

import java.util.Date;
import java.util.UUID;

public class Book {
    private String mAuthor;
    private String mTitle;
    private UUID mId;
    private Date mPublicationDate;

    public Book() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getPublicationDate() {
        return mPublicationDate;
    }

    public void setPublicationDate(Date mPublicationDate) {
        this.mPublicationDate = mPublicationDate;
    }
}
