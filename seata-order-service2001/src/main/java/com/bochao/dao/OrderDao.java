package com.bochao.dao;

import com.bochao.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {

    /**
     * 查询所有订单
     * */
    List<Order> getListOrder();

    /**
     * 新增订单
     * */
    void insert(Order order);

    /**
     * 更新订单状态
     * */
    void updateStatus(@Param("id") String id, @Param("status") Integer status);
}
