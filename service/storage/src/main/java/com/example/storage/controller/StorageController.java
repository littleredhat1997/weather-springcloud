package com.example.storage.controller;

import com.example.common.base.Result;
import com.example.storage.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "库存")
@RestController
@RequestMapping(value = "")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @ApiOperation("扣减库存")
    @GetMapping("decrease")
    public Result<String> decrease(@RequestParam("productId") Long productId,
                                   @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return Result.success();
    }
}
