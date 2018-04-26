package com.yotexs.stock.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yotexs.stock.domain.Goods;
import com.yotexs.stock.rep.GoodsRep;

@Service
public class GoodsServiceImpl {

	GoodsRep gp;

	public GoodsServiceImpl(GoodsRep gp) {
		this.gp = gp;
	}

	public Map<String, String> save(Goods g) {
		gp.save(g);
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("info", "成功");
		return map;
	}

	public List<Goods> list(String g) {
		return gp.findAll((r, q, c) -> c.equal(r.get("goodsName"), g));
	}



}
