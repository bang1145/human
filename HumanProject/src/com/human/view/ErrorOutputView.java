package com.human.view;

import com.human.model.Model;

public class ErrorOutputView implements ViewInterface {

	@Override
	public void execute(Model model) {
		System.out.println("보기에 있는 숫자를 입력하세요");
	}
}
