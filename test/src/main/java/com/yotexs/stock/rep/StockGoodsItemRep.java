package com.yotexs.stock.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yotexs.stock.domain.StockGoodsItem;

public interface StockGoodsItemRep
		extends JpaRepository<StockGoodsItem, Integer>, JpaSpecificationExecutor<StockGoodsItem> {


}
