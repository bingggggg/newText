package com.yotexs.stock.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yotexs.stock.domain.MoveStock;

public interface MoveStockRep extends JpaRepository<MoveStock, Integer>, JpaSpecificationExecutor<MoveStock> {


}
