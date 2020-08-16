package com.wisestudy.groupleader.domain;

public class GroupLeaderMangementPlannerVO {
    private Integer study;
    private String datetime;
    private String place;
    private String description;

    public GroupLeaderMangementPlannerVO(Integer study, String datetime, String place, String description) {
        this.study = study;
        this.datetime = datetime;
        this.place = place;
        this.description = description;
    }

    public Integer getStudy() {
        return study;
    }

    public void setStudy(Integer study) {
        this.study = study;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
