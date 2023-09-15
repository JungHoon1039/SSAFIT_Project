package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Review;

public interface ReviewDao {

    List<Review> selectReviewAll(String youtubeId);

    void insertReview(Review review);

    void deleteReview(String youtubeId, int reviewId);

    void patchReview(String youtubeId, int reviewId, String content);

    Review detailReview(String youtubeId, int reviewId);

}
