package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.User;

public interface UserDao {
	public abstract boolean signin(String id, String name, String passowrd, String email);

	public abstract boolean signout(String id, String password);

	public abstract boolean login(String id, String password);

	public abstract boolean logout();

	public abstract User getLoginUserInfo();

	public abstract List<User> getUserList();
}
