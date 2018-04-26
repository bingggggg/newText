package com.yotexs.stock.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yotexs.stock.domain.StockGoods;

public interface StockGoodsRep extends JpaRepository<StockGoods, Integer>, JpaSpecificationExecutor<StockGoods> {


}
