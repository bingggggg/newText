package com.yotexs.stock.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yotexs.stock.domain.User;
import com.yotexs.stock.rep.UserRep;

@Service
public class UserServiceImpl {

	UserRep up;

	public UserServiceImpl(UserRep up) {
		this.up = up;
	}

	public Map<String, String> save(User u) {
		up.save(u);
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("info", "成功");
		return map;
	}

	public List<User> list() {
		return up.findAll();
	}

	public Map<String, String> show(User u, HttpSession session) {
		if ("admin".equals(u.getUserName()) && "x".equals(u.getUserPwd())) {
			Optional<User> user = up.findOne((r, q, c) -> {
				return c.and(c.equal(r.get("userName"), u.getUserName()), c.equal(r.get("userPwd"), u.getUserPwd()));
			});
			if (!user.isPresent()) {
				up.save(u);
			}
		}

		Optional<User> optional = up.findOne((r, q, c) -> c.equal(r.get("userName"), u.getUserName()));
		Map<String, String> map = new HashMap<>();
		if (optional.isPresent()) {
			User user = optional.get();
			if (user.getUserPwd().equals(u.getUserPwd())) {
				session.setAttribute("user", user);
				map.put("status", "200");
				map.put("info", "成功");
			} else {
				map.put("status", "500");
				map.put("info", "密码错误");
			}
		} else {
			map.put("status", "500");
			map.put("info", "用户名不存在");
		}
		return map;
	}
}
