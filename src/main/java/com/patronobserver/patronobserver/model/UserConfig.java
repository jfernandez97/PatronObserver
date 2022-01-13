package com.patronobserver.patronobserver.model;

import lombok.Data;

@Data
public class UserConfig {
    private String rol;
    private String email;
    private String phone;

    public UserConfig(){}
}
