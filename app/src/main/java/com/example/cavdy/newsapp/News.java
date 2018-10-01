package com.example.cavdy.newsapp;

public class News {
    private String mTitle;
    private String mAuthor;
    public String mUrl;
    private String mDate;
    private String mSection;

    public News(String mTitle, String mUrl) {
        this.mTitle = mTitle;
        this.mUrl = mUrl;
    }

    public News(String mTitle, String mAuthor, String mUrl, String mDate, String mSection) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mUrl = mUrl;
        this.mDate = mDate;
        this.mSection = mSection;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmSection() {
        return mSection;
    }

    public void setmSection(String mSection) {
        this.mSection = mSection;
    }
}
