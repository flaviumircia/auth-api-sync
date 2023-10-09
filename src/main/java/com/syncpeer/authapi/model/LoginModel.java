package com.syncpeer.authapi.model;

import lombok.Getter;
import lombok.Setter;

public class LoginModel {
    @Getter
    @Setter
    String email;
    @Getter
    @Setter
    String password;

    @Override
    public String toString() {
        return "LoginModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
