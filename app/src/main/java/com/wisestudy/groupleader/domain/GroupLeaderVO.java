package com.wisestudy.groupleader.domain;

public class GroupLeaderVO {
    private boolean is_manager;
    private Integer id;
    private String name;
    private String email;
    private String cellphone;
    private String gender;

    public GroupLeaderVO(boolean is_manager, Integer id, String name, String email, String cellphone, String gender) {
        this.is_manager = is_manager;
        this.id = id;
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
        this.gender = gender;
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
}
