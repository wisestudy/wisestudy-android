package com.wisestudy.nongroup.vo;

public class Study {

    private Integer study_id;
    private Integer category_id;
    private String title;
    private Integer limit;
    private String description;

    public Study(Integer study_id, Integer category_id, String title, Integer limit, String description) {
        this.study_id = study_id;
        this.category_id = category_id;
        this.title = title;
        this.limit = limit;
        this.description = description;
    }

    public Integer getStudy_id() {
        return study_id;
    }

    public void setStudy_id(Integer study_id) {
        this.study_id = study_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
