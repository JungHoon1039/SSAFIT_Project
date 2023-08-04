package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.Video;

public class VideoDaoImpl implements VideoDao {
	private List<Video> list = new ArrayList<>();

	private VideoDaoImpl() {
	}

	private static VideoDaoImpl instance = new VideoDaoImpl();

	public static VideoDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Video> selectVideo() {
		return list;
	}

	@Override
	public Video selectVideoByNo(int no) {
		for (Video v : list) {
			if (v.getNo() == no) {
				return v;
			}
		}
		return null;
	}
}
