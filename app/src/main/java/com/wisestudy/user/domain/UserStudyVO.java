package com.wisestudy.user.domain;

public class UserStudyVO {
    private String studyName;
    /**
     * date 타임으로 나중에서 수정
     */
    private String studyDate;
    private String studyLocation;

    public UserStudyVO(String studyName, String studyDate, String studyLocation) {
        this.studyName = studyName;
        this.studyDate = studyDate;
        this.studyLocation = studyLocation;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getStudyDate() {
        return studyDate;
    }

    public void setStudyDate(String studyDate) {
        this.studyDate = studyDate;
    }

    public String getStudyLocation() {
        return studyLocation;
    }

    public void setStudyLocation(String studyLocation) {
        this.studyLocation = studyLocation;
    }
}
