package com.bit2015.mysite.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.mysite.vo.ReplyVo;

@Repository
public class BoardDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings("unchecked")
	public List<BoardVo> getList(int _skip, int _max) {
		List<BoardVo> list = sqlMapClientTemplate.queryForList("board.listkwd",
				_skip, _max);
		// System.out.println("list size=" + list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<BoardVo> getList(int _skip, int _max, String kwd) {
		List<BoardVo> list = sqlMapClientTemplate.queryForList("board.listkwd",
				kwd, _skip, _max);
		// System.out.println("list size=" + list.size());
		return list;
	}

	public List<BoardVo> search(String kwd) {
		return sqlMapClientTemplate.queryForList("board.search");
	}

	public void write(BoardVo boardVo) {
		sqlMapClientTemplate.insert("board.insert", boardVo);
	}

	public void delete(Long no) {
		sqlMapClientTemplate.delete("board.delete", no);

	}

	public BoardVo view(Long no) {
		return (BoardVo) sqlMapClientTemplate.queryForObject("board.view", no);
	}

	public BoardVo get(long no) {
		BoardVo vo = (BoardVo) sqlMapClientTemplate.queryForObject(
				"board.getbyno", no);
		System.out.println(no + "의  vo : " + vo);
		return vo;

	}

	public void update(BoardVo vo) {
		sqlMapClientTemplate.update("board.update", vo);

	}

	public int count() {
		return (int) sqlMapClientTemplate.queryForObject("board.count");
	}

	public List<ReplyVo> getReplyList(Long articleNo) {
		System.out.println("articleNo : " + articleNo);
		List<ReplyVo> list = sqlMapClientTemplate.queryForList("reply.list",
				articleNo);
		// System.out.println(list);
		return list;
	}

	public void addReply(ReplyVo vo) {
		System.out.println("addReply : " + vo);
		sqlMapClientTemplate.insert("reply.insert", vo);

	}

	public void delreply(Long no) {
		System.out.println("delreply : " + no);
		sqlMapClientTemplate.delete("reply.delete", no);

	}

	public void addReReply(ReplyVo rereplyVo) {
		sqlMapClientTemplate.insert("reply.replyreply", rereplyVo);		
	}

	public ReplyVo getReply(Long no) {
		System.out.println( " service getReply : "+no);
		ReplyVo replyVo = (ReplyVo) sqlMapClientTemplate.queryForObject("reply.getreplybyno", no);
		System.out.println("service getReply : " +replyVo);
		return replyVo;
	}
}
