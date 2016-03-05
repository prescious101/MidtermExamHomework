package com.alago.bsit.midtermexamhomework.Entities;

/**
 * Created by BSIT on 3/5/2016.
 */
public class Books {

    private String mId;
    private String mTitle;
    private String mGenre;
    private String mAuthor;
    private Boolean mIsRead;

    public Books() {
    }

    public Books(String mId, String mTitle, String mGenre, String mAuthor, Boolean mIsRead) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mGenre = mGenre;
        this.mAuthor = mAuthor;
        this.mIsRead = mIsRead;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmGenre() {
        return mGenre;
    }

    public void setmGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public Boolean getmIsRead() {
        return mIsRead;
    }

    public void setmIsRead(Boolean mIsRead) {
        this.mIsRead = mIsRead;
    }
}
