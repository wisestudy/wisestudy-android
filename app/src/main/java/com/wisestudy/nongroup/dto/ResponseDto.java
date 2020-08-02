package com.wisestudy.nongroup.dto;

import com.wisestudy.nongroup.vo.Study;

import java.util.List;

public class ResponseDto {

    private Integer category_id;
    private String name;
    private List<Study> study;

    public ResponseDto(Integer category_id, String name, List<Study> study) {
        this.category_id = category_id;
        this.name = name;
        this.study = study;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Study> getStudy() {
        return study;
    }

    public void setStudy(List<Study> study) {
        this.study = study;
    }
}
