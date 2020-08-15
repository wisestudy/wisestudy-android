package com.wisestudy.nongroup.domain;

public class StudyCreateVO {
    private String category;
    private String title;
    private Integer limit;
    private String description;

    public StudyCreateVO(String category, String title, Integer limit, String description) {
        this.category = category;
        this.title = title;
        this.limit = limit;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getDescriptions() {
        return description;
    }

    public void setDescriptions(String descriptions) {
        this.description = descriptions;
    }
}
