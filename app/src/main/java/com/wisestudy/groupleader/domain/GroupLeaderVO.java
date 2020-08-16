package com.wisestudy.groupleader.domain;

public class GroupLeaderVO {
    private boolean is_manager;
    private Integer id;
    private String name;
    private String email;
    private String cellphone;
    private String gender;
    private Integer study_member_id;
    private Integer study;
    private Integer user;
    private Integer age;
    private String categories;

    public GroupLeaderVO(boolean is_manager, Integer id, String name, String email, String cellphone, String gender, Integer study_member_id, Integer study, Integer user, Integer age, String categories) {
        this.is_manager = is_manager;
        this.id = id;
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
        this.gender = gender;
        this.study_member_id = study_member_id;
        this.study = study;
        this.user = user;
        this.age = age;
        this.categories = categories;
    }

    public boolean isIs_manager() {
        return is_manager;
    }

    public void setIs_manager(boolean is_manager) {
        this.is_manager = is_manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getStudy_member_id() {
        return study_member_id;
    }

    public void setStudy_member_id(Integer study_member_id) {
        this.study_member_id = study_member_id;
    }

    public Integer getStudy() {
        return study;
    }

    public void setStudy(Integer study) {
        this.study = study;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
