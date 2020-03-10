package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "城市")
@Controller
@RequestMapping("")
public class CityController {

    @Autowired
    private CityService cityService;

    @ApiOperation("获取城市列表")
    @GetMapping("/cities")
    @ResponseBody
    public List<City> get() throws Exception {
        return cityService.listCity();
    }
}
