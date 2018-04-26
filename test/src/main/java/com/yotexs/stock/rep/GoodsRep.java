package com.yotexs.stock.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yotexs.stock.domain.Goods;

public interface GoodsRep extends JpaRepository<Goods, Integer>, JpaSpecificationExecutor<Goods> {


}
