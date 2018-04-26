package com.yotexs.stock.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yotexs.stock.domain.Supplier;

public interface SupplierRep extends JpaRepository<Supplier, Integer>, JpaSpecificationExecutor<Supplier> {


}
