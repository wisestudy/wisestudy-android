package com.wisestudy.login.domain;

public class LoginVO {
    private String jwt;

    public LoginVO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
