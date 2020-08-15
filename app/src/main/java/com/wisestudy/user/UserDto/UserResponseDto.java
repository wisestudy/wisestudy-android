package com.wisestudy.user.UserDto;

import com.wisestudy.user.domain.UserStudyVO;
import com.wisestudy.user.domain.UserVO;

import java.util.List;

public class UserResponseDto {
    private Integer code;
    private String status;
    private UserVO message;

    public UserResponseDto(Integer code, String status, UserVO message) {
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

    public UserVO getMessage() {
        return message;
    }

    public void setMessage(UserVO message) {
        this.message = message;
    }

}
