package com.example.account.service;

import com.example.account.dao.AccountDao;
import com.example.common.base.GlobalException;
import com.example.common.base.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public void decrease(Long userId, BigDecimal money) {
        log.info("------->扣减余额开始");
        boolean result = accountDao.decrease(userId, money);
        if (!result) throw new GlobalException(Status.FAILURE); // 异常
        log.info("------->扣减余额结束");
    }
}
