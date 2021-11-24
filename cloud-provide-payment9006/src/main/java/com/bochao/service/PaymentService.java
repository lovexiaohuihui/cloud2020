package com.bochao.service;

import com.bochao.entity.Payment;

public interface PaymentService {

    /**
     * 插入数据
     * */
    int addPayment(Payment payment);

    /**
     * 查询数据
     * */
    Payment getPaymentById(String id);
}
