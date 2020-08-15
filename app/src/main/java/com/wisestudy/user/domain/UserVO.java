package com.wisestudy.user.domain;

import java.util.List;

public class UserVO {

    private Integer user_id;
    private String email;
    private String name;
    private Integer age;
    private String cellphone;
    private String gender;
    private String categories;
    private String description;

    public List<UserStudyVO> study_list;

    public UserVO(Integer user_id, String email, String name, Integer age, String cellphone, String gender, String categories, String description) {
        this.user_id = user_id;
        this.email = email;
        this.name = name;
        this.age = age;
        this.cellphone = cellphone;
        this.gender = gender;
        this.categories = categories;
        this.description = description;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserStudyVO> getStudy_list() {
        return study_list;
    }

    public void setStudy_list(List<UserStudyVO> study_list) {
        this.study_list = study_list;
    }
}

