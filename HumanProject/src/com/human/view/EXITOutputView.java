package com.human.view;

import com.human.model.Model;

public class EXITOutputView implements ViewInterface {

	@Override
	public void execute(Model model) {
		System.out.println("--------------------------");
		System.out.println("프로그램을 종료합니다");
		model.setAttribute("input", 5);
	}
}
