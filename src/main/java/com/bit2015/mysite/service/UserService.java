package com.bit2015.mysite.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite.dao.UserDao;
import com.bit2015.mysite.vo.UserVo;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public void join(UserVo userVo) {
		userDao.insert(userVo);
	}

	public UserVo login(UserVo userVo) {
		UserVo vo = userDao.get(userVo.getEmail(), userVo.getPassword());
		System.out.println("UserService : " + vo);
		return vo;
	}

	public void update(UserVo userVo) {
		userDao.update(userVo);
		
	}
	public String getByEmail(String email){
		return userDao.getByEmail(email);
	}
	

}
