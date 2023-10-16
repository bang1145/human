package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.human.dto.CustomerDto;
import com.human.util.DBConn;

public class CustomerDao {
	public ArrayList<CustomerDto> select(){
		
		ArrayList<CustomerDto> resultDtos= new ArrayList<CustomerDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from customer"));
		try {
			while(rs.next()) {
				resultDtos.add(new CustomerDto(rs.getInt("id")
						,rs.getString("name"), rs.getDouble("height")
						,rs.getTimestamp("birthday").toLocalDateTime()));
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return resultDtos;
		}
		public CustomerDto selectId(int id) {
			CustomerDto resultDtos=new CustomerDto();
			ResultSet rs=DBConn.statementQuery(String.format("select * from customer where id=%id", id));
			if(rs!=null) {
				try {
					rs.next();
					resultDtos=new CustomerDto(rs.getInt("id")
							,rs.getString("name"), rs.getDouble("height")
							,rs.getTimestamp("birthday").toLocalDateTime());
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
				}				
			}
			return resultDtos;
	}
		public void insert (CustomerDto dto) {
			String sql=String.format("insert into customer values("
		+"%d, '%s', %f, to_date('%s', 'yyyy-mm-dd HH24:mi:ss'))", dto.getId(),dto.getName()
		,dto.getHeight(), 
		dto.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
			DBConn.statementUpdate(sql);
			System.out.println("[입력 완료]");			
		}
		public void update(String updatename, int updateage) {
			String sql = String.format("update customer set id='%id' where name='%s'",
					updatename, updateage);
			DBConn.statementQuery(sql);
			System.out.println("[수정 완료]");
		}
		public void delete(int id) {
			String sql = String.format("delete customer where id=%id", id);
			DBConn.statementUpdate(sql);
			System.out.println("[삭제 완료]");
		}
		public ArrayList<Integer> getIds(){
			ArrayList<Integer> ids = new ArrayList<Integer>();
			ResultSet rs = DBConn.statementQuery(String.format("select * from customer"));
			try {
				while(rs.next()) {
					ids.add(rs.getInt("id"));
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return ids;
		}
		public int getMaxId() {
			int maxIdValue=-1;
			ResultSet rs = DBConn.statementQuery(
					String.format("select max(id) as maxId from customer"));
			if(rs!=null) {
				try {
					rs.next();
					maxIdValue=rs.getInt("maxId");					
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			return maxIdValue;
		}
}