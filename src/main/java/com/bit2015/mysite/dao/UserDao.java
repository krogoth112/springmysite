package com.bit2015.mysite.dao;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public UserVo get(String no) {

		UserVo vo = (UserVo) sqlMapClientTemplate.queryForObject(
				"guestbook.getvon", no);

		return vo;
	}

	public UserVo get(String email, String password) {

		java.util.HashMap<String, String> map = new java.util.HashMap<String, String>(
				2);
		map.put("email", email);
		map.put("password", password);
		UserVo vo = (UserVo) sqlMapClientTemplate.queryForObject(
				"user.getbyEmailAndPassword", map);

		return vo;

	}
	public String getByEmail(String email) {
		
		return (String) sqlMapClientTemplate.queryForObject("user.getbyemail", email);
	}
	

	// insert
	public void insert(UserVo vo){
		sqlMapClientTemplate.insert("user.insert", vo);
	}

	// update
	public void update(UserVo vo){
		sqlMapClientTemplate.update("user.update", vo);

	}

}
