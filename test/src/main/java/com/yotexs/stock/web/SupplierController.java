package com.yotexs.stock.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yotexs.stock.domain.Supplier;
import com.yotexs.stock.service.SupplierServiceImpl;

@Controller
public class SupplierController {

	SupplierServiceImpl ss;

	public SupplierController(SupplierServiceImpl ss) {
		this.ss = ss;
	}

	@RequestMapping("supplier/save")
	@ResponseBody
	public Map<String, String> save(Supplier s) {
		return ss.save(s);
	}

	@RequestMapping("supplier/save/login")
	public String goodsLogin() {
		return "";
	}


}
