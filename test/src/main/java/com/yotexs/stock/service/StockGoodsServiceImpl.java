package com.yotexs.stock.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.yotexs.stock.domain.Goods;
import com.yotexs.stock.domain.StockGoods;
import com.yotexs.stock.domain.StockGoodsItem;
import com.yotexs.stock.rep.GoodsRep;
import com.yotexs.stock.rep.StockGoodsItemRep;
import com.yotexs.stock.rep.StockGoodsRep;

@Service
public class StockGoodsServiceImpl {

	StockGoodsRep sgp;
	GoodsRep gp;
	StockGoodsItemRep sgip;

	public StockGoodsServiceImpl(StockGoodsRep sgp, GoodsRep gp, StockGoodsItemRep sgip) {
		this.sgp = sgp;
		this.gp = gp;
		this.sgip = sgip;
	}

	public List<StockGoods> list(String inout) {
		return sgp.findAll((r, q, c) -> c.equal(r.get("inout"), inout));
	}

	@Transactional
	public Map<String, String> save(String inout, String warehosue, List<String> ids, List<String> numbers) {
		StockGoods s = new StockGoods();
		s.setInOut(inout);
		String optCode = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String optDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		s.setOptCode(optCode);
		s.setOptDate(optDate);
		s.setWarehosue(warehosue);

		BigDecimal money = BigDecimal.ZERO;
		Integer number = 0;

		String supplier = "";
		BigDecimal tradePrice = BigDecimal.ZERO;

		for (int i = 0; i < ids.size(); i++) {
			String id = ids.get(i);
			Optional<Goods> optional = gp.findOne((r, q, c) -> c.equal(r.get("id"), id));
			if (optional.isPresent()) {
				Goods goods = optional.get();
				StockGoodsItem item = new StockGoodsItem();
				item.setGoodsCode(goods.getGoodsCode());
				item.setGoodsName(goods.getGoodsName());
				item.setNumber(numbers.get(i));
				item.setOptCode(optCode);
				item.setOptDate(optDate);
				item.setPrice(goods.getTradePrice().toString());
				item.setSupplier(goods.getSupplier());
				item.setUnit("双");
				item.setWarehosue(warehosue);
				sgip.save(item);
				number += Integer.getInteger(numbers.get(i));
				money = (goods.getTradePrice().multiply(new BigDecimal(numbers.get(i)))).add(money);
				supplier = goods.getSupplier();
				tradePrice = goods.getTradePrice();
			}
		}
		s.setMoney(money);
		s.setSupplier(supplier);
		s.setTradePrice(tradePrice);
		s.setNumber(number.toString());
		sgp.save(s);
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("info", "500");
		return map;
	}

}
