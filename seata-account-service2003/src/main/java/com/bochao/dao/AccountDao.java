package com.bochao.dao;

import com.bochao.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {

    /**
     * 根据用户id,查询用户账户
     * */
    Account getAccountByUserId(@Param("userId") String userId);

    /**
     * 扣钱
     * */
    void deductMoney(Account account);
}
