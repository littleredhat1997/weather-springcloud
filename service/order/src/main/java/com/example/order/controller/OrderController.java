package com.example.order.controller;

import com.example.common.base.Result;
import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "订单")
@RestController
@RequestMapping(value = "")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("创建订单")
    @GetMapping("create")
    public Result<String> create(Order order) {
        orderService.create(order);
        return Result.success();
    }
}
