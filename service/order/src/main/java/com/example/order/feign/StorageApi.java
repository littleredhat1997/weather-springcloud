package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "storage-server")
public interface StorageApi {

    @GetMapping(value = "/decrease")
    String decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
