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
import com.yotexs.stock.domain.MoveStock;
import com.yotexs.stock.domain.MoveStockItem;
import com.yotexs.stock.rep.GoodsRep;
import com.yotexs.stock.rep.MoveStockItemRep;
import com.yotexs.stock.rep.MoveStockRep;

@Service
public class MoveStockServiceImpl {

	MoveStockRep msp;
	GoodsRep gp;
	MoveStockItemRep msip;

	public MoveStockServiceImpl(MoveStockRep msp, GoodsRep gp, MoveStockItemRep msip) {
		this.msp = msp;
		this.gp = gp;
		this.msip = msip;
	}

	public List<MoveStock> list() {
		return msp.findAll();
	}

	@Transactional
	public Map<String, String> save(String outWarehosue, String inWarehosue, List<String> ids, List<String> numbers) {
		MoveStock s = new MoveStock();
		String optCode = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String optDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		s.setOptCode(optCode);
		s.setOptDate(optDate);
		s.setInWarehosue(inWarehosue);
		s.setOutWarehosue(outWarehosue);
		BigDecimal money = BigDecimal.ZERO;
		Integer number = 0;

		String supplier = "";
		BigDecimal tradePrice = BigDecimal.ZERO;

		for (int i = 0; i < ids.size(); i++) {
			String id = ids.get(i);
			Optional<Goods> optional = gp.findOne((r, q, c) -> c.equal(r.get("id"), id));
			if (optional.isPresent()) {
				Goods goods = optional.get();
				MoveStockItem item = new MoveStockItem();
				item.setGoodsCode(goods.getGoodsCode());
				item.setGoodsName(goods.getGoodsName());
				item.setNumber(numbers.get(i));
				item.setOptCode(optCode);
				item.setOptDate(optDate);
				item.setSupplier(goods.getSupplier());
				item.setUnit("双");
				item.setPrice(goods.getTradePrice().toString());
				msip.save(item);
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
		msp.save(s);
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("info", "500");
		return map;
	}

}
