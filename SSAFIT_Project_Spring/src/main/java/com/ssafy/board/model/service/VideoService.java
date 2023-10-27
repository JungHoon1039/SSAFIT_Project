package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Review;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.Video;

public interface VideoService {
    List<Review> reviewSelectAll(String youtubeId);

    Review reviewSelect(int id);

    int reviewAdd(Review review);

    int reviewModify(Review review);

    int reviewRemove(int id);

    List<Video> search(SearchCondition condition);
}
