package com.ssafy.fit.model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.ssafy.fit.model.Video;

public class VideoDaoImpl implements VideoDao {
	private List<Video> list = new ArrayList<>();

	private VideoDaoImpl() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")))) {
			StringBuilder sb = new StringBuilder();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str).append("\n");
			}
			Gson gson = new Gson();
			Video[] arr = gson.fromJson(sb.toString(), Video[].class);
			list = Arrays.asList(arr);
		} catch (Exception e) {
			System.out.println("파일 읽기 실패");
			e.printStackTrace();
		}
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
