package com.bochao.service;

import com.bochao.dao.OrderDao;
import com.bochao.domain.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    public List<Order> getListOrder() {
        return orderDao.getListOrder();
    }

    /**
     * 下订单服务
     * 新增订单->扣减库存->扣除金额->订单完成
     * */
    @GlobalTransactional(name = "seata-order", rollbackFor = Exception.class)
    public void createOrder() {
        log.info("创建订单开始--------------------");
        Double money = new Double(100);
        // 1- 新增订单
        log.info("新增订单开始--------------------");
        Order order = new Order();
        String id = UUID.randomUUID().toString();
        order.setId(id);
        order.setUserId("1");
        order.setCount(1);
        order.setMoney(money);
        order.setProductId("1");
        order.setStatus(0);
        orderDao.insert(order);
        log.info("新增订单结束--------------------");
        // 2- 扣减库存
        log.info("扣减库存开始--------------------");
        storageService.reduce(order.getProductId(), 1);
        log.info("扣减库存结束--------------------");
        // 3- 扣除金额
        log.info("扣钱开始--------------------");
        accountService.deductMoney(order.getUserId(), money);
        log.info("扣钱结束--------------------");
        // 4- 更新订单状态
        log.info("更新订单开始--------------------");
        orderDao.updateStatus(id, 1);
        log.info("更新订单结束--------------------");
        log.info("创建订单结束--------------------");
    }
}
