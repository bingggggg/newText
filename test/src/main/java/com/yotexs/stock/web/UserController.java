package com.yotexs.stock.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yotexs.stock.domain.User;
import com.yotexs.stock.service.UserServiceImpl;

@Controller
public class UserController {

	UserServiceImpl user;
	public UserController(UserServiceImpl user) {
		this.user = user;
	}

	@RequestMapping("user/login")
	public String userLogin(Model model){
		model.addAttribute("data", user.list());
		return "";
	}

	@RequestMapping("user/save")
	@ResponseBody
	public Map<String, String> save(User u) {
		return user.save(u);
	}

	@RequestMapping("user/save/login")
	public String saveLogin() {
		return "";
	}

	@RequestMapping("user/show")
	@ResponseBody
	public Map<String, String> show(HttpSession session, User u) {
		return user.show(u, session);
	}

	@RequestMapping("user/re")
	public String re(HttpSession session) {
		session.removeAttribute("user");
		return "";
	}
}
