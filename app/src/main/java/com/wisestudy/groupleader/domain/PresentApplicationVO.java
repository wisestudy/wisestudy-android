package com.wisestudy.groupleader.domain;

public class PresentApplicationVO {
    private String name;
    private String phone;
    private String des;
    private String field;

    public PresentApplicationVO(String name, String phone, String des, String field) {
        this.name = name;
        this.phone = phone;
        this.des = des;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
