package com.ssafy.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.board.model.dao.ReviewDaoImpl;
import com.ssafy.board.model.dto.Review;
import com.ssafy.board.model.dto.User;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
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
        case "insert":
            doReviewInsert(request, response);
            break;
        case "delete":
            doReviewDelete(request, response);
            break;
        case "patch":
            doReviewPatch(request, response);
            break;
        case "detail":
            doReviewDetail(request, response);
            break;
        case "selectAll":
            doReviewSelectAll(request, response);
            break;
        }
    }

    private void doReviewInsert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String youtubeId = request.getParameter("youtubeId");
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") != null) {
            ReviewDaoImpl ri = ReviewDaoImpl.getInstance();
            int userSeq = ((User) session.getAttribute("loginUser")).getUserSeq();
            String content = request.getParameter("content");
            Review review = new Review(youtubeId, userSeq, content);
            ri.insertReview(review);
        }
        response.sendRedirect(request.getContextPath() + "/main.jsp");
    }

    private void doReviewDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String youtubeId = request.getParameter("youtubeId");
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        ReviewDaoImpl ri = ReviewDaoImpl.getInstance();
        List<Review> reviews = ri.selectReviewAll(youtubeId);
        int userSeq = 0;
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getReviewId() == reviewId) {
                userSeq = reviews.get(i).getUserSeq();
            }
        }
        if (session.getAttribute("loginUser") != null
                && ((User) session.getAttribute("loginUser")).getUserSeq() == userSeq) {
            ri.deleteReview(youtubeId, reviewId);
        }
        response.sendRedirect(request.getContextPath() + "/main.jsp");
    }

    private void doReviewPatch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String youtubeId = request.getParameter("youtubeId");
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        ReviewDaoImpl ri = ReviewDaoImpl.getInstance();
        List<Review> reviews = ri.selectReviewAll(youtubeId);
        int userSeq = 0;
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getReviewId() == reviewId) {
                userSeq = reviews.get(i).getUserSeq();
            }
        }
        if (session.getAttribute("loginUser") != null
                && ((User) session.getAttribute("loginUser")).getUserSeq() == userSeq) {
            String content = request.getParameter("content");
            ri.patchReview(youtubeId, reviewId, content);
        }
        response.sendRedirect(request.getContextPath() + "/main.jsp");
    }

    private void doReviewDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String youtubeId = request.getParameter("youtubeId");
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        ReviewDaoImpl ri = ReviewDaoImpl.getInstance();
        request.setAttribute("detailReview", ri.detailReview(youtubeId, reviewId));
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }

    private void doReviewSelectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String youtubeId = request.getParameter("youtubeId");
        ReviewDaoImpl ri = ReviewDaoImpl.getInstance();
        request.setAttribute("reviewList", ri.selectReviewAll(youtubeId));
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }

}
