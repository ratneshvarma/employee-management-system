package com.ratnesh.ems.model;

import org.springframework.stereotype.Component;

/**
 * Created by ratnesh on 25/5/17.
 */
@Component
public class Login {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    private boolean remember;
}
