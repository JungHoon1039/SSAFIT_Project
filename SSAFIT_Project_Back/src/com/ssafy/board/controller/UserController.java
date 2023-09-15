package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.board.model.dao.UserDaoImpl;
import com.ssafy.board.model.dto.User;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
        case "signup":
            doSignUp(request, response);
            break;
        case "login":
            doLogin(request, response);
            break;
        case "logout":
            doLogout(request, response);
            break;
        }
    }

    private void doSignUp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userSeq = 0; // Integer.parseInt(request.getParameter("userSeq"));
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        String nickName = request.getParameter("nickName");
        String email = request.getParameter("email");
        User user = new User(userSeq, userId, password, userName, nickName, email);
        boolean signup = UserDaoImpl.getInstance().signup(user);
        if (signup) {
            HttpSession session = request.getSession();
            UserDaoImpl um = UserDaoImpl.getInstance();
            session.setAttribute("loginUser", um.login(userId, password));
            response.sendRedirect(request.getContextPath() + "/main.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/fail.jsp?action=signup");
        }

    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        UserDaoImpl um = UserDaoImpl.getInstance();
        User login = um.login(userId, password);
        if (login != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", login);
            response.sendRedirect(request.getContextPath() + "/main.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/fail.jsp?action=login");
        }
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/main.jsp");
    }

}
