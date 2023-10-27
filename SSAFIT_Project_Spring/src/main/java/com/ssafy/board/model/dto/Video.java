package com.ssafy.board.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "영상 모델", description = "영상 정보")
public class Video {
    private int id;
    private String youtubeId;
    private String title;
    private String part;
    private String channelName;
    private String url;
    private int viewCnt;

    public Video() {
    }

    public Video(String youtubeId, String title, String part, String channelName, String url) {
        this.youtubeId = youtubeId;
        this.title = title;
        this.part = part;
        this.channelName = channelName;
        this.url = url;
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

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    @Override
    public String toString() {
        return "Video [id=" + id + ", youtubeId=" + youtubeId + ", title=" + title + ", part=" + part + ", channelName="
                + channelName + ", url=" + url + ", viewCnt=" + viewCnt + "]";
    }

}
