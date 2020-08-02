package com.wisestudy.groupleader.domain;

import android.graphics.drawable.Drawable;

public class CalendarModifyVO {

    private Drawable image;
    private Integer day;
    private String location;
    private String name;

    public CalendarModifyVO(Drawable image, Integer day, String location, String name) {
        this.image = image;
        this.day = day;
        this.location = location;
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
