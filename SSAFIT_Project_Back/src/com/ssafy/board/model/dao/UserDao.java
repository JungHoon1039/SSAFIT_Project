package com.ssafy.board.model.dao;

import com.ssafy.board.model.dto.User;

public interface UserDao {

    User login(String id, String password);

    boolean signup(User user);

    String getNickName(int userSeq);
}
