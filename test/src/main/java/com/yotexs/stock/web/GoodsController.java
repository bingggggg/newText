package com.yotexs.stock.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yotexs.stock.domain.Goods;
import com.yotexs.stock.service.GoodsServiceImpl;

@Controller
public class GoodsController {

	GoodsServiceImpl gs;

	public GoodsController(GoodsServiceImpl gs) {
		this.gs = gs;
	}

	@RequestMapping("goods/save")
	@ResponseBody
	public Map<String, String> save(Goods g) {
		return gs.save(g);
	}

	@RequestMapping("goods/save/login")
	public String goodsLogin() {
		return "";
	}

	@RequestMapping("goods/show")
	@ResponseBody
	public List<Goods> show(String u) {
		return gs.list(u);
	}

}
