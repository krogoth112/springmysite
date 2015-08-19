package com.bit2015.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.mysite.service.GuestBookService;
import com.bit2015.mysite.vo.GuestBookVo;

@Controller
 @RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
	GuestBookService guestBookService;

	@RequestMapping("/insert")
	public String insesrt(@ModelAttribute GuestBookVo guestBookVo) {
		guestBookService.insert(guestBookVo);
		return "redirect:/guestbook/index";

	}

	@RequestMapping("/index")
	public String list(Model model) {
		System.out.println(" list index index index index");
		List<GuestBookVo> list = guestBookService.list();
		model.addAttribute("list", list);

		return "/guestbook/index";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam String password, long no) {

		GuestBookVo vo = new GuestBookVo();
		vo.setPassword(password);
		vo.setNo(no);

		guestBookService.delete(vo);

		return "redirect:/guestbook/index";

	}

	@RequestMapping("/deleteform/{no}")
	public String deleteForm(@PathVariable("no") long no, Model model) {

		System.out.println("no : " + no);
		model.addAttribute("no", no);
		return "guestbook/deleteform";

	}

}
