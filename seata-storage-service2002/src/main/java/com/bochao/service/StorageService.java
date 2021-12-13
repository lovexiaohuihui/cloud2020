package com.bochao.service;

import com.bochao.dao.StorageDao;
import com.bochao.domain.Storage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageService {

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     * */
    public void reduce(String productId, Integer count) {
        Storage storage = storageDao.getStorageByProductId(productId);
        storage.setUsed(storage.getUsed() + count);
        storage.setResidue(storage.getResidue() - count);
        storageDao.reduce(storage);
    }
}
