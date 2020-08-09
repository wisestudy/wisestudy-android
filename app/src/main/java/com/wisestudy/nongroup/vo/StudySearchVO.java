package com.wisestudy.nongroup.vo;

import android.graphics.drawable.Drawable;

public class StudySearchVO {

    private Drawable image;
    private String title;
    private Integer member;
    private String description;

    public StudySearchVO(String title, Integer member, String description) {
        this.title = title;
        this.member = member;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}