package com.yotexs.stock.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yotexs.stock.domain.Stock;
import com.yotexs.stock.service.StockServiceImpl;

@Controller
public class StockController {

	StockServiceImpl ss;

	public StockController(StockServiceImpl ss) {
		this.ss = ss;
	}

	@RequestMapping("stock/save")
	@ResponseBody
	public Map<String, String> save(Stock s) {
		return ss.save(s);
	}

	@RequestMapping("stock/save/login")
	public String goodsLogin() {
		return "";
	}


}
