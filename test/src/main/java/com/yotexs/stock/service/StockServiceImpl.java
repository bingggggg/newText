package com.yotexs.stock.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yotexs.stock.domain.Stock;
import com.yotexs.stock.rep.StockRep;

@Service
public class StockServiceImpl {

	StockRep sp;

	public StockServiceImpl(StockRep sp) {
		this.sp = sp;
	}

	public Map<String, String> save(Stock s) {
		sp.save(s);
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("info", "成功");
		return map;
	}




}
