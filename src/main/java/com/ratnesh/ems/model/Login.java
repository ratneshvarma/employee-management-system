package com.ratnesh.ems.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by ratnesh on 25/5/17.
 */
//@Component
@Entity
@Table(name = "designation")
public class Login {
    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }
    @Id
    @Column(name="loginId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long loginId;
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
