package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.fit.model.VideoReview;

public class VideoReviewDaoImpl implements VideoReviewDao {
	private int reviewNo;
	private Map<Integer, List<VideoReview>> videoReviewDb = new HashMap<>();

	private VideoReviewDaoImpl() {
	}

	private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();

	public static VideoReviewDaoImpl getInstance() {
		return instance;
	}

	@Override
	public int insertReview(VideoReview videoReview) {
		int key = videoReview.getVideoNo();
		videoReviewDb.putIfAbsent(key, new ArrayList<>());
		videoReviewDb.get(key).add(videoReview);
		return 0;
	}

	@Override
	public List<VideoReview> selectReview(int videoNo) {
		return videoReviewDb.get(videoNo);
	}

}
