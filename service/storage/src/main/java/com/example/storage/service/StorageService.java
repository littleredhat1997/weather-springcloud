package com.example.storage.service;

import com.example.common.base.GlobalException;
import com.example.common.base.Status;
import com.example.storage.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageService {

    @Autowired
    private StorageDao storageDao;

    public void decrease(Long productId, Integer count) {
        log.info("------->扣减库存开始");
        boolean result = storageDao.decrease(productId, count);
        if (!result) throw new GlobalException(Status.STORAGE_FAILURE); // 异常
        log.info("------->扣减库存结束");
    }
}
