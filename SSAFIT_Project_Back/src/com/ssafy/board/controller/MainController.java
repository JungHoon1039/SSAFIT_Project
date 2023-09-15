package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.dao.MainDao;
import com.ssafy.board.model.dao.MainDaoImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MainDao mainDao = MainDaoImpl.getInstance();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String part = request.getParameter("part");
        request.setAttribute("interestList", mainDao.selectInterestViewFitVideo());
        request.setAttribute("partList", mainDao.selectPartFitVideo(part));
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
