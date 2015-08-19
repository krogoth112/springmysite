package com.bit2015.mysite.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit2015.mysite.service.UserService;
import com.bit2015.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/joinform")
	public String joinform() {

		return "user/joinform";

	}

	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		userService.join(userVo);

		return "user/joinsuccess";
	}

	@RequestMapping("/joinsuccess")
	public String joinsuccess(@ModelAttribute UserVo userVo) {

		return "user/joinsuccess";
	}

	@RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo userVo) {
		System.out.println("!!!");
		UserVo vo = userService.login(userVo);
		if (vo == null) {
			return "redirect:/user/loginform";
		}
		session.setAttribute("authUser", vo);
		System.out.println(vo);
		return "redirect:/";
	}

	@RequestMapping("/loginform")
	public String loginform() {

		return "user/loginform";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/update")
	public String update(HttpSession session, @ModelAttribute UserVo userVo) {
		System.out.println(userVo);
		userService.update(userVo);
		session.setAttribute("authUser", userVo);
		return "user/updatesuccess";
	}

	@RequestMapping("/updateform")
	public String updateform(HttpSession session) {

		return "user/updateform";
	}

	@RequestMapping("/checkemail")
	@ResponseBody
	public HashMap checkEmail(@RequestParam("email") String email) {
		System.out.println("email : " + email);
		String reusltedemail = userService.getByEmail(email);
		System.out.println("reusltedemail : " + reusltedemail);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", (reusltedemail == null) ? "not exist" : "exist");
		System.out.println("map : " + map);
		return map;
	}
	
	@RequestMapping("/checkname")
	@ResponseBody
	public ModelAndView checkname(@RequestParam("name") String name) {
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		return mv;
	}

}
