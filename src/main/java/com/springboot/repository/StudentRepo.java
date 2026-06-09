package com.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.model.StudentBean;

@Repository
public class StudentRepo {

	@Autowired
	JdbcTemplate jdbc;
	
	public int save(StudentBean obj) {
		int i=0;
		String sql="insert into student (name,age,gender,email,photo) values (?,?,?,?,?)";   
		
		i=jdbc.update(sql,obj.getName(),obj.getAge(),obj.getGender(),obj.getEmail(),obj.getPhoto());
		
		
		return i;
		
	}
	
	
}
