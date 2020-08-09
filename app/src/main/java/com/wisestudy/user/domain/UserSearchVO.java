package com.wisestudy.user.domain;

import java.util.Date;

public class UserSearchVO {

    private String email;
    private String name;
    private Date birthday;
    private String phone;
    private String sex;

    public UserSearchVO(String email, String name, Date birthday, String phone, String sex) {
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.sex = sex;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
