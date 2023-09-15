package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Video;

public interface MainDao {

    List<Video> selectInterestViewFitVideo();

    List<Video> selectPartFitVideo(String part);

}
