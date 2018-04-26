package com.yotexs.stock.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yotexs.stock.domain.Supplier;
import com.yotexs.stock.rep.SupplierRep;

@Service
public class SupplierServiceImpl {

	SupplierRep sp;

	public SupplierServiceImpl(SupplierRep sp) {
		this.sp = sp;
	}

	public Map<String, String> save(Supplier s) {
		sp.save(s);
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("info", "成功");
		return map;
	}




}
