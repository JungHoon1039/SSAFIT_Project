package com.ssafy.board.model.dto;

import java.util.Date;

import com.ssafy.board.model.dao.ReviewDaoImpl;

public class Review {
    private int reviewId;
    private String youtubeId;
    private String content;
    private Date regDate;
    private String nickName;

    public Review() {
    }

    public Review(String youtubeId, String nickName,String content) {
        this.reviewId = ReviewDaoImpl.getInstance().selectReviewAll(youtubeId).size() + 1;
        this.youtubeId = youtubeId;
        this.content = content;
        this.nickName= nickName;
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
		return "Review [reviewId=" + reviewId + ", youtubeId=" + youtubeId + ", content=" + content + ", regDate="
				+ regDate + ", nickName=" + nickName + "]";
	}


}
