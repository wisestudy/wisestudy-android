package com.wisestudy.groupleader.domain;

public class GroupMemberVO {
    private String name;
    private String age;
    private String field;

    public GroupMemberVO(String name, String age, String field) {
        this.name = name;
        this.age = age;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
