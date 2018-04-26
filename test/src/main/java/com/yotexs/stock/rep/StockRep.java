package com.yotexs.stock.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yotexs.stock.domain.Stock;

public interface StockRep extends JpaRepository<Stock, Integer>, JpaSpecificationExecutor<Stock> {


}
