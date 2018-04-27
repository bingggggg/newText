package com.yotexs.stock.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class WebInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws IOException {
		if (req.getSession().getAttribute("user") == null) {
			res.sendRedirect("");
			return true;
		}
		return false;

	}
}
