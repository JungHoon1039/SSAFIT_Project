package com.ssafy.fit.ui;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;
import com.ssafy.fit.model.dao.UserDaoImpl;
import com.ssafy.fit.util.SsafitUtil;

public class MainUi {
    public static void service() {
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 회원정보");
        System.out.println("0. 종료");
        SsafitUtil.printLine();
        int startPage = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
        if (startPage == 1) {
            String userId = SsafitUtil.input("id : ");
            String userPw = SsafitUtil.input("password : ");
            if (UserDaoImpl.getInstance().login(userId, userPw)) {
                VideoUi.service();
            }
        } else if (startPage == 2) {
            String userId = SsafitUtil.input("id : ");
            String userName = SsafitUtil.input("name : ");
            String userPw = SsafitUtil.input("password : ");
            String userEmail = SsafitUtil.input("email : ");
            if (UserDaoImpl.getInstance().signin(userId, userName, userPw, userEmail)) {
                service();
            }
        } else if (startPage == 3) {
            System.out.println(UserDaoImpl.getInstance().getUserList());
            service();
        } else if (startPage == 0) {
            exit();
        }
    }

    public static void exit() {
        SsafitUtil.screenClear();
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/user.json")))) {
            Gson gson = new Gson();
            String str = gson.toJson(UserDaoImpl.getInstance().getUserList().toArray());
            bw.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}