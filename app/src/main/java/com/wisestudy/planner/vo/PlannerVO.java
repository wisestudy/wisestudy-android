package com.wisestudy.planner.vo;


public class PlannerVO {
    private Integer schedule_id;
    private String study;
    private String datetime;
    private String place;
    private String address;
    private String title;
    private String description;

    public PlannerVO(Integer schedule_id, String study, String datetime, String place, String address, String title, String description) {
        this.schedule_id = schedule_id;
        this.study = study;
        this.datetime = datetime;
        this.place = place;
        this.address = address;
        this.title = title;
        this.description = description;
    }

    public Integer getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Integer schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}