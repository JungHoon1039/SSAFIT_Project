package com.ssafy.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Review;

public class ReviewDaoImpl implements ReviewDao {
    private static ReviewDaoImpl instance;
    private Map<String, List<Review>> reviewList = new HashMap<>();

    private ReviewDaoImpl() {
    }

    public static ReviewDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReviewDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Review> selectReviewAll(String youtubeId) {
        return reviewList.get(youtubeId);
    }

    @Override
    public void insertReview(Review review) {
        String youtubeId = review.getYoutubeId();
        List<Review> reviews = reviewList.get(youtubeId);
        if (reviews == null) {
            reviews = new ArrayList<>();
            reviewList.put(youtubeId, reviews);
        }
        reviews.add(review);
    }

    @Override
    public void deleteReview(String youtubeId, int reviewId) {
        List<Review> reviews = reviewList.get(youtubeId);
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getReviewId() == reviewId) {
                reviews.remove(reviews.get(i));
            }
        }
    }

    @Override
    public void patchReview(String youtubeId, int reviewId, String content) {
        List<Review> reviews = reviewList.get(youtubeId);
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getReviewId() == reviewId) {
                reviews.get(i).setContent(content);
            }
        }
    }

    @Override
    public Review detailReview(String youtubeId, int reviewId) {
        List<Review> reviews = reviewList.get(youtubeId);
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getReviewId() == reviewId) {
                return reviews.get(i);
            }
        }
        return null;
    }

}
