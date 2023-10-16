package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class DeleteInputView implements ViewInterface{
	
	@Override
	public void execute(Model model) {
		System.out.println("--------------------------");
		System.out.println("삭제할 데이터 입력: ");
		int id = UserInput.inputInt("id 입력: ");
		model.setAttribute("id", id);
	}
}
