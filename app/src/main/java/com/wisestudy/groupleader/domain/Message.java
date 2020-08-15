package com.wisestudy.groupleader.domain;

import java.util.List;

public class Message {
    private List<GroupLeaderVO> study_members;

    public Message(List<GroupLeaderVO> study_members) {
        this.study_members = study_members;
    }

    public List<GroupLeaderVO> getStudy_members() {
        return study_members;
    }

    public void setStudy_members(List<GroupLeaderVO> study_members) {
        this.study_members = study_members;
    }
}
