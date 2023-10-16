package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.human.dto.HumanDto;
import com.human.util.DBConn;

public class HumanDao {
	
	public void init() {

		HumanDto dto=new HumanDto("홍길동", 30, 152.1,
				LocalDateTime.parse("2000-02-03 00:00:00",
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		String sql =String.format(	
				"insert into human values('%s',%d,%f,to_date('%s','YYYY:MM:DD HH24:MI:SS'))"
				,dto.getName(),dto.getAge(),dto.getHeight()
				,dto.getBirthday().format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		DBConn.statementUpdate(sql);

		dto=new HumanDto("홍길동", 31, 156.4,
				LocalDateTime.parse("2000-02-03 00:00:00",
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		sql =String.format(
				"insert into human values('%s',%d,%f,to_date('%s','YYYY:MM:DD HH24:MI:SS'))"
				,dto.getName(),dto.getAge(),dto.getHeight()
				,dto.getBirthday().format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		DBConn.statementUpdate(sql);

		dto=new HumanDto("홍길영", 33, 173.5,
				LocalDateTime.parse("2000-12-21 00:00:00",
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		sql =String.format(
				"insert into human values('%s',%d,%f,to_date('%s','YYYY:MM:DD HH24:MI:SS'))"
				,dto.getName(),dto.getAge(),dto.getHeight()
				,dto.getBirthday().format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		DBConn.statementUpdate(sql); 
	}

	public void insert(HumanDto dto) {
		String sql =String.format(			
				"insert into human values('%s',%d,%f,to_date('%s','YYYY:MM:DD HH24:MI:SS'))"
				,dto.getName(),dto.getAge(),dto.getHeight()
				,dto.getBirthday().format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		DBConn.statementUpdate(sql); 
	}

	public void update(String name,int age) {
		DBConn.statementUpdate(String.format(
				"update human set age=%d where name='%s'",age,name));
	}

	public void delete(int age) {
		DBConn.statementUpdate(String.format("delete human where age < %d", age));
	}

	public  ArrayList<HumanDto> select() {
		ArrayList<HumanDto> resultDtos=new ArrayList<HumanDto>();
		ResultSet rs=DBConn.statementQuery(
				String.format("select * from human"));

		try {
			while(rs.next()) {
				resultDtos.add(new HumanDto(						
						rs.getString("name"),
						rs.getInt("age"),
						rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime())); 
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;
	}	
	public ArrayList<HumanDto> select(double height) {
		ArrayList<HumanDto> resultDtos=new ArrayList<HumanDto>();
		ResultSet rs=DBConn.statementQuery(
				String.format("select * from human where height>%d",height));
		try {
			while(rs.next()) {
				resultDtos.add(new HumanDto(
						rs.getString("name"),
						rs.getInt("age"),
						rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime())); 
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
}