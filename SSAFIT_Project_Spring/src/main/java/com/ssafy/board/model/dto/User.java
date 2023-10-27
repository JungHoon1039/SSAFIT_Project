package com.ssafy.board.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "유저 모델", description = "유저 정보")
public class User {
    private int id;
    private String userId;
    private String password;
    private String name;

    public User() {
    }

    public User(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + "]";
    }

}
