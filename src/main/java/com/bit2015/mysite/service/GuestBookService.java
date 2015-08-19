package com.bit2015.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite.dao.GuestBookDao;
import com.bit2015.mysite.vo.GuestBookVo;

@Service
public class GuestBookService {
	@Autowired
	GuestBookDao guestBookDao;

	public void insert(GuestBookVo vo) {
		guestBookDao.insert(vo);

	}

	public List<GuestBookVo> list() {
		List<GuestBookVo> list = guestBookDao.getList();
		return list;

	}

	public void delete(GuestBookVo vo) {

		guestBookDao.delete(vo);

	}

}
