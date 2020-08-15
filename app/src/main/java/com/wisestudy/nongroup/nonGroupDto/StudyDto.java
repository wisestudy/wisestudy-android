package com.wisestudy.nongroup.nonGroupDto;

import com.wisestudy.nongroup.domain.StudyVO;
import com.wisestudy.user.domain.UserVO;

import java.util.List;

public class StudyDto {
    private Integer code;
    private String status;
    private StudyVO message;

    public StudyDto(Integer code, String status, StudyVO message) {
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

    public StudyVO getMessage() {
        return message;
    }

    public void setMessage(StudyVO message) {
        this.message = message;
    }
}
