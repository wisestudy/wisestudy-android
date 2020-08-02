package com.wisestudy.nongroup.activity.vo;

public class StudySearchVO {
    private int image;
    private String name;
    private String field;
    private int number;

    public StudySearchVO(int image, String name, String field, int number) {
        this.image = image;
        this.name = name;
        this.field = field;
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
