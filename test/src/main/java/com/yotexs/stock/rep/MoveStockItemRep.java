package com.yotexs.stock.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yotexs.stock.domain.MoveStockItem;

public interface MoveStockItemRep
		extends JpaRepository<MoveStockItem, Integer>, JpaSpecificationExecutor<MoveStockItem> {


}
