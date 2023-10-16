package com.human.view;

import com.human.model.Model; 
import com.human.util.UserInput; 

public class MainMenuView implements ViewInterface{

	@Override
	public void execute(Model model) {
		String strMainMenu="Human Table 관리 프로그램\n";
		strMainMenu+="1.출력 2.입력 3.삭제 4.수정 5.종료\n";
		strMainMenu+="메뉴 번호를 골라 주세요 ";
		model.setAttribute("input", UserInput.inputInt(strMainMenu));
	}	
}
