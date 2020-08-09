package com.wisestudy.user.domain;

import java.util.List;

public class UserVO {

    private String name;
    private Integer age;
    private String phone;
    private List<UserStudyVO> list;

    public UserVO(String name, Integer age, String phone, List<UserStudyVO> list) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.list = list;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<UserStudyVO> getList() {
        return list;
    }

    public void setList(List<UserStudyVO> list) {
        this.list = list;
    }
}
