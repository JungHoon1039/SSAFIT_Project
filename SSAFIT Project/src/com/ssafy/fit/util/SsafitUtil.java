package com.ssafy.fit.util;

import java.util.Scanner;

public class SsafitUtil {
	private static Scanner sc = new Scanner(System.in);
	private SsafitUtil ssafitUtil = new SsafitUtil();

	public static String input(String msg) {
		System.out.print(msg);
		String input = sc.next();
		return input;
	}

	public static int inputInt(String msg) {
		System.out.print(msg);
		int input = sc.nextInt();
		return input;
	}

	public static void printLine() {
		System.out.println("--------------------------------------------------");
	}

	public static void printLine(char ch) {
		System.out.println(ch);
	}

	public static void printLine(char ch, int len) {
	}

	public static void screenClear() {

	}

}