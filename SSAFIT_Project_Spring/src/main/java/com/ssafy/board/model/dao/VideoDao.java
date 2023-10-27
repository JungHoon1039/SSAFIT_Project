package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Review;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.Video;

public interface VideoDao {
    public List<Review> reviewSelectAll(String youtubeId);

    public List<Video> search(SearchCondition condition);

    public Review reviewSelect(int id);

    public int reviewAdd(Review review);

    public int reviewModify(Review review);

    public int reviewRemove(int id);

}
