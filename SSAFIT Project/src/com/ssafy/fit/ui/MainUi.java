package com.ssafy.fit.ui;

import com.ssafy.fit.util.SsafitUtil;

public class MainUi {
	public static void service() {
		SsafitUtil.printLine();
		System.out.println("1. 영상 정보");
		System.out.println("0. 종료");
		SsafitUtil.printLine();
		int startPage = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		if (startPage == 1) {
			VideoUi.service();
		} else if (startPage == 0) {
			exit();
		}
	}

	public static void exit() {
		SsafitUtil.screenClear();
	}
}