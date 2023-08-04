package com.ssafy.fit.model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.ssafy.fit.model.User;

public class UserDaoImpl implements UserDao {
    private List<User> list = new ArrayList<>();

    private User loginUserInfo = null;

    private UserDaoImpl() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/user.json")))) {
            StringBuilder sb = new StringBuilder();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
            Gson gson = new Gson();
            User[] arr = gson.fromJson(sb.toString(), User[].class);
            if (arr != null) {
                list = new ArrayList<>(Arrays.asList(arr));
            }
        } catch (Exception e) {
            System.out.println("파일 읽기 실패");
            e.printStackTrace();
        }
    }

    private static UserDaoImpl instance = new UserDaoImpl();

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean signin(String id, String name, String passowrd, String email) {
        for (User user : list) {
            if (user.getId().equals(id)) {
                return false;
            }
        }
        list.add(new User(id, name, passowrd, email));
        return true;
    }

    @Override
    public boolean signout(String id, String password) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                if (list.get(i).getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean login(String id, String password) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                if (list.get(i).getPassword().equals(password)) {
                    loginUserInfo = list.get(i);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean logout() {
        if (loginUserInfo != null) {
            loginUserInfo = null;
            return true;
        }
        return false;
    }

    @Override
    public User getLoginUserInfo() {
        if (loginUserInfo != null) {
            return loginUserInfo;
        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        return list;
    }
}
