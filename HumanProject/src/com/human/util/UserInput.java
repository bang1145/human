package com.human.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInput {
	
	private static Scanner sc=new Scanner(System.in);
	public static int inputInt(String st) {
		System.out.println(st+" 정수입력>>");
		return Integer.parseInt(sc.nextLine());
	}
	public static double inputDouble(String st) {
		System.out.println(st+" 실수입력>>");
		return Double.parseDouble(sc.nextLine());
	}
	public static String inputString(String st) {
		System.out.println(st+" 문자입력>>");
		return sc.nextLine();
	}
	public static LocalDateTime inputLocalDateTime(String str) {
		System.out.println(str+" 시간입력(yyyy-MM-dd HH:mm:ss)>>");
		return LocalDateTime.parse(sc.nextLine(),
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	public static String dateToString(LocalDateTime date) {
		return date.format(DateTimeFormatter.ofPattern(
				"yyyy-MM-dd HH:mm:ss"));
	}
}
