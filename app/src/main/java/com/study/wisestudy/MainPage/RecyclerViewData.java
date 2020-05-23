package com.study.wisestudy.MainPage;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewData {
    private int pic;
    private String title;
    private String contents;
    private String Date;


    public RecyclerViewData(int p,String t,String c,String d) {
        this.pic=p;
        this.title=t;
        this.contents=c;
        this.Date=d;
    }
    public RecyclerViewData(String t,String c,String d){
        this.title=t;
        this.contents=c;
        this.Date=d;
    }

    public int getPic() {
        return pic;
    }

    public String getContents() {
        return contents;
    }

    public String getDate() {
        return Date;
    }

    public String getTitle() {
        return title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
