package com.example.account.controller;

import com.example.account.service.AccountService;
import com.example.common.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Api(tags = "余额")
@RestController
@RequestMapping("")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation("扣减余额")
    @GetMapping("decrease")
    public Result<String> decrease(@RequestParam("userId") Long userId,
                                   @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return Result.success();
    }
}
