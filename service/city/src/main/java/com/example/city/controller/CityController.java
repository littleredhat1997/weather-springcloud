package com.example.city.controller;

import com.example.city.entity.City;
import com.example.city.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "城市")
@RestController
@RequestMapping("")
public class CityController {

    @Autowired
    private CityService cityService;

    @ApiOperation("获取城市列表")
    @GetMapping("/cities")
    public List<City> get() throws Exception {
        return cityService.listCity();
    }
}
