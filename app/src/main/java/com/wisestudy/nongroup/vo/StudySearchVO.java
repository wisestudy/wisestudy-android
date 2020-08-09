package com.wisestudy.nongroup.vo;

import android.graphics.drawable.Drawable;

public class StudySearchVO {
    private Drawable image;
    private String title;
    private String locaton;
    private String member;
    private String description;

    public StudySearchVO(String title, String locaton, String member, String description) {
        this.title = title;
        this.locaton = locaton;
        this.member = member;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocaton() {
        return locaton;
    }

    public void setLocaton(String locaton) {
        this.locaton = locaton;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
