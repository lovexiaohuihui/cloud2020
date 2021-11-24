package com.bochao.service.impl;

import com.bochao.dao.PaymentDao;
import com.bochao.entity.Payment;
import com.bochao.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int addPayment(Payment payment) {
        payment.setId(UUID.randomUUID().toString());
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(String id) {
        return paymentDao.getPaymentById(id);
    }
}
