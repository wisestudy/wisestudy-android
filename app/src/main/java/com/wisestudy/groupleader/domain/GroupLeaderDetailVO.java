package com.wisestudy.groupleader.domain;

public class GroupLeaderDetailVO {
    private Integer study_id;
    private Integer category;
    private String title;
    private Integer limit;
    private String description;

    public GroupLeaderDetailVO(Integer study_id, Integer category, String title, Integer limit, String description) {
        this.study_id = study_id;
        this.category = category;
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
