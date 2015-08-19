package com.bit2015.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.dao.UserDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.mysite.vo.ReplyVo;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	

	// public List<BoardVo> list(){
	// return boardDao.getList();
	//
	// }
	
/*	String email = request.getParameter("email");
	String reEmail = UserDao.getInstance().get(email);
	// {"result": "exist"}
	// {"result": "not exist"}
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("result", (reEmail == null) ? "not exist" : "exist");

	JSONObject jsonObject = JSONObject.fromObject(map);

	response.setContentType("application/json; charset=utf-8");
	PrintWriter out = response.getWriter();

	out.print(jsonObject.toString());*/
	

	public List<BoardVo> search(String kwd) {
		return boardDao.search(kwd);
	}

	public void write(BoardVo boardVo) {
		boardDao.write(boardVo);
	}

	public void delete(Long no) {
		boardDao.delete(no);
	}

	public BoardVo view(Long no) {
		return boardDao.view(no);
	}

	public int countrow() {
		return boardDao.count();
	}

	public List<BoardVo> list(int _skip, int _max) {
		List<BoardVo> list = boardDao.getList(_skip, _max);
		return list;

	}

	public List<BoardVo> list(int _skip, int _max, String kwd) {
		List<BoardVo> list = boardDao.getList(_skip, _max, kwd);
		return list;

	}

	public BoardVo get(long no) {
		return boardDao.get(no);
	}

	public void delete(long no) {
		boardDao.delete(no);
	}

	public void update(BoardVo vo) {
		boardDao.update(vo);
	}

	public void delreply(Long no) {
		boardDao.delreply(no);

	}

	public List<ReplyVo> getReplyList(Long no) {
		return boardDao.getReplyList(no);

	}

	public void addreply(ReplyVo vo) {
		boardDao.addReply(vo);

	}

	public void addReReply(ReplyVo rereplyVo) {
		boardDao.addReReply(rereplyVo);
	}

	public ReplyVo getReply(Long no) {
		// TODO Auto-generated method stub
		return boardDao.getReply(no);
	}

}
