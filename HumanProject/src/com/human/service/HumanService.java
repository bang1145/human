package com.human.service;

import java.util.ArrayList;
import com.human.dao.HumanDao;
import com.human.dto.HumanDto;

public class HumanService {
	private HumanDao dao=new HumanDao();
	public void init() {
		dao.init();
	}

	public void insert(HumanDto dto) {
		dao.insert(dto);
	}

	public void update(String name,int age) {
		dao.update(name, age);
	}
	public void delete(int age) {
		dao.delete(age);
	}

	public ArrayList<HumanDto> select(){
		return dao.select();	
	}
	public ArrayList<HumanDto> select(double height){
		if(height <100) {
			height=height+100;
		}
		return dao.select(height);
	}
}
