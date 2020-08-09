package com.example.order.service;

import com.example.order.entity.Order;
import com.example.order.feign.AccountApi;
import com.example.order.feign.StorageApi;
import com.example.order.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountApi accountApi;

    @Autowired
    private StorageApi storageApi;

    // @GlobalTransactional(name = "my_test_tx_group", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------->交易开始");
        orderDao.create(order);

        log.info("------->扣减余额开始");
        accountApi.decrease(order.getUserId(), order.getMoney());
        log.info("------->扣减余额结束");

        log.info("------->扣减库存开始");
        storageApi.decrease(order.getProductId(), order.getCount());
        log.info("------->扣减库存结束");

        orderDao.update(order.getUserId(), 1);
        log.info("------->交易结束");
    }
}
