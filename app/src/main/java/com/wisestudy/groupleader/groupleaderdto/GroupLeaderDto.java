package com.wisestudy.groupleader.groupleaderdto;

import com.wisestudy.groupleader.domain.GroupLeaderVO;
import com.wisestudy.groupleader.domain.Message;

import java.util.List;

public class GroupLeaderDto {
    private Integer code;
    private String status;
    private Message message;

    public GroupLeaderDto(Integer code, String status, Message message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
