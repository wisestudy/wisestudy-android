package com.study.wisestudy.MainPage;


public class RecyclerViewData {
    private int imageIndex;
    private String title;
    private String contents;
    private String date;


    public RecyclerViewData(int imageIndex, String title, String contents, String date) {
        this.imageIndex = imageIndex;
        this.title = title;
        this.contents = contents;
        this.date = date;
    }
    public RecyclerViewData(String title, String contents, String date){
        this.title = title;
        this.contents = contents;
        this.date = date;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public String getContents() {
        return contents;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
