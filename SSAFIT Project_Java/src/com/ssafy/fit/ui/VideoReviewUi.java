package com.ssafy.fit.ui;

import java.util.List;

import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.UserDaoImpl;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;
import com.ssafy.fit.util.SsafitUtil;

public class VideoReviewUi {

	public static int videoNo;
	static VideoReviewDao videoReviewDao = VideoReviewDaoImpl.getInstance();

	private VideoReviewUi(int videoNo) {

	}

	private VideoReviewUi instance = new VideoReviewUi(videoNo);

	public VideoReviewUi getInstance(int videoNo) {
		return instance;
	}

	public static void service() {
		List<VideoReview> videoReviewList = videoReviewDao.selectReview(videoNo);
		SsafitUtil.printLine();
		System.out.println("영상리뷰 : " + videoReviewList.size());
		SsafitUtil.printLine();
		listReview();
	}

	public static void listReview() {
		List<VideoReview> videoReviewList = videoReviewDao.selectReview(videoNo);
		for (int i = 0; i < videoReviewList.size(); i++) {
			System.out.println((i + 1) + " " + videoReviewList.get(i).getContent());
		}
		SsafitUtil.printLine();
		System.out.println("1. 리뷰등록");
		System.out.println("0. 이전으로");
		int reviewPage = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		if (reviewPage == 1) {
			registReview();
		} else if (reviewPage == 0) {
			VideoUi.listVideo();
		}
	}

	public static void registReview() {
		String content = SsafitUtil.input("내용을 입력하세요 : ");
		VideoReview videoReview = new VideoReview(videoNo, 0, UserDaoImpl.getInstance().getLoginUserInfo().getName(),
				content);
		videoReviewDao.insertReview(videoReview);
		service();
	}

}