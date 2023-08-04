package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.VideoReview;

public interface VideoReviewDao {
	public abstract int insertReview(VideoReview videoReview);

	public abstract List<VideoReview> selectReview(int videoNo);
}
