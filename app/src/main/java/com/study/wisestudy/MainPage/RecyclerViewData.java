package com.study.wisestudy.MainPage;


public class RecyclerViewData {
    private int picture;
    private String title;
    private String contents;
    private String date;


    public RecyclerViewData(int picture,String title,String contents,String date) {
        this.picture=picture;
        this.title=title;
        this.contents=contents;
        this.date=date;
    }
    public RecyclerViewData(String title,String contents,String date){
        this.title=title;
        this.contents=contents;
        this.date=date;
    }

    public int getPic() {
        return picture;
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
        date = date;
    }

    public void setPic(int picture) {
        this.picture = picture;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
