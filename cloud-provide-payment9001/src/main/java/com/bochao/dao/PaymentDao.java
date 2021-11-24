package com.bochao.dao;

import com.bochao.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    /**
     * 插入数据
     * */
    int addPayment(Payment payment);

    /**
     * 查询数据
     * */
    Payment getPaymentById(@Param("id") String id);
}
