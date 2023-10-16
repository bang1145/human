package com.human.view;

import com.human.model.Model; 
import com.human.util.UserInput;

public class UpdateInputView implements ViewInterface{

	@Override
	public void execute(Model model) {
		System.out.println("--------------------------");
		String updateName=UserInput.inputString("수정할 이름 입력: ");
		int updateAge = UserInput.inputInt("수정할 나이 입력");
		model.setAttribute("updateName", updateName);
		model.setAttribute("updateAge", updateAge);
	}
}
