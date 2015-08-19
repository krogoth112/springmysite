package com.bit2015.mysite.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite.vo.GuestBookVo;


@Repository
public class GuestBookDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void insert(GuestBookVo vo) {
		sqlMapClientTemplate.insert("guestbook.insert", vo);

	}

	public void delete(GuestBookVo vo) {
		sqlMapClientTemplate.delete("guestbook.delete", vo);

	}

	public List<GuestBookVo> getList() {
		List<GuestBookVo> list = sqlMapClientTemplate
				.queryForList("guestbook.list");
		return list;

	}

}
