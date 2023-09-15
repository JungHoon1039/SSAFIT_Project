package com.ssafy.board.model.dto;

import java.util.Date;

import com.ssafy.board.model.dao.ReviewDaoImpl;

public class Review {
    private int reviewId;
    private String youtubeId;
    private int userSeq;
    private String content;
    private Date regDate;

    public Review() {
    }

    public Review(String youtubeId, int userSeq, String content) {
        this.reviewId = ReviewDaoImpl.getInstance().selectReviewAll(youtubeId).size() + 1;
        this.youtubeId = youtubeId;
        this.userSeq = userSeq;
        this.content = content;
        this.regDate = new Date();
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", youtubeId=" + youtubeId + ", userSeq=" + userSeq + ", content="
                + content + ", regDate=" + regDate + "]";
    }

}
