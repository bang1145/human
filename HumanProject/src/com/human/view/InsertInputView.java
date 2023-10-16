package com.human.view;

import com.human.dto.CustomerDto; 
import com.human.model.Model; 
import com.human.util.UserInput; 


public class InsertInputView implements ViewInterface{

	@Override
	public void execute(Model model) {
		System.out.println("--------------------------");
		System.out.println("입력할 Customer 데이터 입력");
		CustomerDto dto=new CustomerDto();
		dto.setId(UserInput.inputInt("id 입력 "));
		dto.setName(UserInput.inputString("이름 입력 "));
		dto.setHeight(UserInput.inputDouble("키 입력 "));
		dto.setBirthday(UserInput.inputLocalDateTime("생일 입력 "));
		model.setAttribute("dto", dto);
	}	
}
