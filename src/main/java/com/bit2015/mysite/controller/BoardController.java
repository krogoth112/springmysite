package com.bit2015.mysite.controller;

import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.mysite.service.BoardService;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.mysite.vo.ReplyVo;
import com.bit2015.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	class page{
		int skip;
		int t_page;
		int s_page;
		int c_m_page;
		public int countrow(){
			return (int) Math.ceil((boardService.countrow() / (double) 6)); 
		}
		
	}
	@Autowired
	BoardService boardService;

	@RequestMapping("/{no}")
	public String list(@PathVariable("no") Integer c_page,
			@RequestParam(required = false) String kwd, Model model) {
		int skip = (c_page - 1) * 6;
		List<BoardVo> list = kwd == null ? boardService.list(skip, 6)
				: boardService.list(skip, 6, kwd);
		System.out.println("kwd " + kwd);
		// List<BoardVo> list = boardService.list(skip, 6);
		int t_page = (int) Math.ceil((boardService.countrow() / (double) 6));
		int s_page;
		int c_m_page;
		if (t_page == 1) {
			s_page = c_page;
			c_m_page = c_page;
			// System.out.println("totalpage 1");
		} else if (t_page == 2) {
			if (c_page == 1) {
				s_page = c_page;
			} else {
				s_page = c_page - 1;
			}
			c_m_page = 2;
			// System.out.println("totalpage 2");
		} else {
			// System.out.println("totalpage 3이상");
			s_page = 1;
			c_m_page = 3;

			if (c_page == t_page) {
				s_page = c_page - 2;
				c_m_page = c_page;
			}
			if (c_page > 1 && c_page != 2 && c_page != t_page) {
				s_page = c_page - 1;
				c_m_page = c_page + 1;
			}
			if (c_page == t_page - 1) {
				c_m_page = c_page + 1;
			}
		}
		// System.out.println("시작페이지는 " + s_page);
		// System.out.println("현재 페이지는 " + c_page);
		// System.out.println("현재 표시할 맥스 페이지는 " + c_m_page);
		model.addAttribute("c_page", c_page);
		model.addAttribute("s_page", s_page);
		model.addAttribute("c_m_page", c_m_page);
		model.addAttribute("t_page", t_page);
		model.addAttribute("list", list);
		return "/board/list";
	}

	@RequestMapping("/writeform")
	public String writeform() {
		return "/board/write";

	}

	@RequestMapping("/write")
	public String write(@RequestParam String content, String title,
			HttpSession session) {
		System.out.println("!!!!");
		UserVo userVo = (UserVo) session.getAttribute("authUser");

		if (userVo == null)
			return "redirct:/user/loginform";

		BoardVo boardVo = new BoardVo();
		boardVo.setMemberNo(userVo.getNo());
		boardVo.setMemberName(userVo.getName());
		boardVo.setContent(content);
		boardVo.setTitle(title);
		System.out.println(boardVo);
		boardService.write(boardVo);

		return "redirect:/board/1";
	}

	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable Long no, HttpSession session) {
		if (no == null && session == null)
			return "redirect:/board/";
		System.out.println("글의 no: " + no + ", " + session);
		boardService.delete(no);
		return "redirect:/board/1";

	}

	@RequestMapping("/view/{no}")
	public String view(@PathVariable Long no, Model model) {

		model.addAttribute("vo", boardService.view(no));
		model.addAttribute("replyList", boardService.getReplyList(no));

		return "/board/view";
	}

	@RequestMapping("/addreply/{no}")
	public String addReply(@PathVariable Long no,
			@RequestParam(required = false) String replyContent,
			HttpSession session) {

		if (session == null) {
			return "redirect:/board/1";
		}
		System.out.println("!!!");
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		ReplyVo vo = new ReplyVo();
		vo.setArticleNo(no);
		vo.setContent(replyContent);
		vo.setMemberName(userVo.getName());
		vo.setMemberNo(userVo.getNo());
		System.out.println("저장할 vo의 값 : " + vo);

		boardService.addreply(vo);

		return "redirect:/board/view/" + no;

	}

	@RequestMapping("/deletereply/{no}")
	public String deleteReply(@PathVariable Long no,
			@RequestParam Long articleNo) {
		boardService.delreply(no);

		return "redirect:/board/view/" + articleNo;
	}

	@RequestMapping("/replyreplyform")
	public String replyreplyform(@RequestParam Long replyNo,
			@RequestParam Long articleNo, Model model) {

		model.addAttribute("replyNo", replyNo);

		return "/board/replyreplyform";
	}

	@RequestMapping("/replyreply")
	public String replyreply(@RequestParam Long replyNo,
			@RequestParam String replyContent, Model model, HttpSession session) {
		if (session == null)
			return "redirect:/user/loginform";
		System.out.println("replyNo : " + replyNo);
		ReplyVo tatgetReplyVo = boardService.getReply(replyNo);
		System.out.println(tatgetReplyVo);
		

		UserVo userVo = (UserVo) session.getAttribute("authUser");
		System.out.println("userVo : "+userVo);
		ReplyVo rereplyVo = new ReplyVo();
		rereplyVo.setArticleNo(tatgetReplyVo.getArticleNo());
		rereplyVo.setContent(replyContent);
		rereplyVo.setMemberNo(tatgetReplyVo.getMemberNo());
		rereplyVo.setMemberName(userVo.getName());
		rereplyVo.setGroupNo(tatgetReplyVo.getGroupNo());
		rereplyVo.setOrderNo(tatgetReplyVo.getOrderNo() + 1);
		rereplyVo.setDepth(tatgetReplyVo.getDepth() + 1);
		
		System.out.println("rereplyVo : " + rereplyVo);
		boardService.addReReply(rereplyVo);
		
		model.addAttribute("rereplyVo", rereplyVo);

		return "redirect:/board/view/" + rereplyVo.getArticleNo();
	}

}
