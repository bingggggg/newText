package com.yotexs.stock.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yotexs.stock.domain.User;

public interface UserRep extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {


}
