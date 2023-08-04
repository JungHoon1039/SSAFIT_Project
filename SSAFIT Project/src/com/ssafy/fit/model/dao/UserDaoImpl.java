package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.User;

public class UserDaoImpl implements UserDao {
	private List<User> list = new ArrayList<>();

	private class LoginUserInfo {
		private boolean login;
		private String id;

		public LoginUserInfo() {
		}

		public LoginUserInfo(boolean bool) {
			this.login = bool;
		}

		public boolean islogin() {
			return login;
		}

		public void setlogin(boolean islogin) {
			this.login = islogin;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}

	private LoginUserInfo loginUserInfo = new LoginUserInfo(false);

	private UserDaoImpl() {
	}

	private static UserDaoImpl instance = new UserDaoImpl();

	public static UserDaoImpl getInstance() {
		return instance;
	}

	@Override
	public boolean signin(String id, String name, String passowrd, String email) {
		for (User user : list) {
			if (user.getId() == id) {
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
			if (list.get(i).getId() == id) {
				if (list.get(i).getPassword() == password) {
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
			if (list.get(i).getId() == id) {
				if (list.get(i).getPassword() == password) {
					System.out.println("로그인 되었습니다.");
					loginUserInfo.setlogin(true);
					loginUserInfo.setId(id);
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
		if (loginUserInfo.islogin()) {
			loginUserInfo.setlogin(false);
			loginUserInfo.setId(null);
			System.out.println("로그아웃 되었습니다.");
			return true;
		}
		System.out.println("이미 로그아웃 상태입니다.");
		return false;
	}

	@Override
	public String getLoginUserInfo() {
		if (loginUserInfo.islogin()) {
			System.out.printf("현재 로그인 중인유저는 %s입니다.", loginUserInfo.getId());
			return loginUserInfo.getId();
		}
		System.out.println("로그아웃 상태입니다.");
		return null;
	}

	@Override
	public List<User> getUserList() {
		return list;
	}
}
