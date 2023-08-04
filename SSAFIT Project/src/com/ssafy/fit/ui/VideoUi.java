package com.ssafy.fit.ui;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.UserDaoImpl;
import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.util.SsafitUtil;

public class VideoUi {
	static VideoDao videoDao = VideoDaoImpl.getInstance();

	private VideoUi() {
	}

	private VideoUi instance = new VideoUi();

	public VideoUi getInstance() {
		return instance;
	}

	public static void service() {
		SsafitUtil.printLine();
		System.out.println("1. 영상 목록");
		System.out.println("2. 로그아웃");
		SsafitUtil.printLine();
		int mainPage = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		if (mainPage == 1) {
			listVideo();
		} else if (mainPage == 2) {
			UserDaoImpl.getInstance().logout();
			MainUi.service();
		}
	}

	public static void listVideo() {
		SsafitUtil.printLine();
		System.out.println("전체 " + videoDao.selectVideo().size() + "개");
		SsafitUtil.printLine();
		for (int i = 0; i < videoDao.selectVideo().size(); i++) {
			System.out.println((i + 1) + " " + videoDao.selectVideo().get(i).getTitle());
		}
		SsafitUtil.printLine();
		System.out.println("1. 영상상세");
		System.out.println("0. 이전으로");
		SsafitUtil.printLine();
		int videoPage = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		if (videoPage == 1) {
			detailVideo();
		} else if (videoPage == 0) {
			service();
		}

	}

	public static void detailVideo() {
		VideoReviewUi.videoNo = SsafitUtil.inputInt("영상번호를 입력하세요 : ");
		Video video = videoDao.selectVideoByNo(VideoReviewUi.videoNo);
		SsafitUtil.printLine();
		System.out.println("번호 : " + video.getNo());
		System.out.println("제목 : " + video.getTitle());
		System.out.println("운동 : " + video.getPart());
		System.out.println("영상 URL : " + video.getUrl());
		SsafitUtil.printLine();
		VideoReviewUi.service();
	}
}