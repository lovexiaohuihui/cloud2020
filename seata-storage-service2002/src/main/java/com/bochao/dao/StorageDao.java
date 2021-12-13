package com.bochao.dao;

import com.bochao.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    /**
     * 根据商品id，查询库存信息
     * */
    Storage getStorageByProductId(@Param("productId") String productId);

    /**
     * 扣减库存
     * */
    void reduce(Storage storage);
}
