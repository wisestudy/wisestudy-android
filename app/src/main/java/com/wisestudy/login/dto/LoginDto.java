package com.wisestudy.login.dto;

import com.wisestudy.login.domain.LoginVO;

public class LoginDto {
    private Integer code;
    private String status;
    private LoginVO message;

    public LoginDto(Integer code, String status, LoginVO message) {
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

    public LoginVO getMessage() {
        return message;
    }

    public void setMessage(LoginVO message) {
        this.message = message;
    }
}
