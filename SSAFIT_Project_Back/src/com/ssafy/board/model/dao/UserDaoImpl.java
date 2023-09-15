package com.ssafy.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.User;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance;

    private List<User> users = new ArrayList<>();

    private UserDaoImpl() {
        User u1 = new User(0, "김싸피id", "김싸피pw", "김싸피이름", "김싸피", "김싸피이메일");
        User u2 = new User(1, "ssafy.hongid", "ssafy.hongpw", "ssafy.hong이름", "ssafy.hong", "ssafy.hong이메일");
        User u3 = new User(2, "삼식이id", "삼식이pw", "삼식이이름", "삼식이", "삼식이이메일");
        User u4 = new User(3, "해피바이러스id", "해피바이러스pw", "해피바이러스이름", "해피바이러스", "해피바이러스이메일");
        signup(u1);
        signup(u2);
        signup(u3);
        signup(u4);
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public User login(String id, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(id) && users.get(i).getPassword().equals(password)) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean signup(User user) {
        if (users.contains(user)) {
            return false;
        }
        users.add(user);
        return true;
    }

    @Override
    public String getNickName(int userSeq) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserSeq() == userSeq) {
                return users.get(i).getNickName();
            }
        }
        return null;
    }

}
