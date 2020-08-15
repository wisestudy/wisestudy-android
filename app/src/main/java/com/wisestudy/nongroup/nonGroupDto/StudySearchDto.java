package com.wisestudy.nongroup.nonGroupDto;

import com.wisestudy.nongroup.domain.StudyVO;

import java.util.List;

public class StudySearchDto {
    private Integer code;
    private String status;
    private List<StudyVO> message;

    public StudySearchDto(Integer code, String status, List<StudyVO> message) {
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

    public List<StudyVO> getMessage() {
        return message;
    }

    public void setMessage(List<StudyVO> message) {
        this.message = message;
    }
}
