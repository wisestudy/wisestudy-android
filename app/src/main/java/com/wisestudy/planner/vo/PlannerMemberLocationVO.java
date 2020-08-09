package com.wisestudy.planner.vo;

public class PlannerMemberLocationVO {
    private String name;
    private String nowLocation;

    public PlannerMemberLocationVO(String name, String nowLocation) {
        this.name = name;
        this.nowLocation = nowLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNowLocation() {
        return nowLocation;
    }

    public void setNowLocation(String nowLocation) {
        this.nowLocation = nowLocation;
    }
}
