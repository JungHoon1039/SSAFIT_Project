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
			list = new ArrayList<>(Arrays.asList(arr));
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
				System.out.println("이미 존재하는 id입니다.");
				return false;
			}
		}
		list.add(new User(id, name, passowrd, email));
		System.out.println("회원가입 되었습니다.");
		return true;
	}

	@Override
	public boolean signout(String id, String password) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				if (list.get(i).getPassword().equals(password)) {
					System.out.println("회원탈퇴 되었습니다.");
					return true;
				} else {
					System.out.println("비밀번호가 틀렸습니다. 회원탈퇴 할 수 없습니다.");
					return false;
				}
			}
		}
		System.out.println("존재하지 않는 id입니다. 회원탈퇴 할 수 없습니다.");
		return false;
	}

	@Override
	public boolean login(String id, String password) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				if (list.get(i).getPassword().equals(password)) {
					System.out.println("로그인 되었습니다.");
					loginUserInfo = list.get(i);
					return true;
				} else {
					System.out.println("비밀번호가 틀렸습니다. 로그인 할 수 없습니다.");
					return false;
				}
			}
		}
		System.out.println("존재하지 않는 id입니다. 로그인 할 수 없습니다.");
		return false;
	}

	@Override
	public boolean logout() {
		if (loginUserInfo != null) {
			loginUserInfo = null;
			System.out.println("로그아웃 되었습니다.");
			return true;
		}
		System.out.println("이미 로그아웃 상태입니다.");
		return false;
	}

	@Override
	public User getLoginUserInfo() {
		if (loginUserInfo != null) {
			System.out.printf("현재 로그인 중인유저는 %s입니다.", loginUserInfo.getId());
			return loginUserInfo;
		}
		System.out.println("로그아웃 상태입니다.");
		return null;
	}

	@Override
	public List<User> getUserList() {
		return list;
	}
}
