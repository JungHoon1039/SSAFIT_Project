package com.ssafy.board.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "리뷰 모델", description = "리뷰 정보")
public class Review {
    private int id;
    private String youtubeId;
    private String title;
    private String content;
    private String writer;
    private int viewCnt;
    private String regDate;

    public Review() {
    }

    public Review(String youtubeId, String title, String content, String writer) {
        this.youtubeId = youtubeId;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", youtubeId=" + youtubeId + ", title=" + title + ", content=" + content
                + ", writer=" + writer + ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
    }

}
