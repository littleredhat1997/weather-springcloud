package com.example.demo.controller;

import com.example.demo.base.Result;
import com.example.demo.entity.Weather;
import com.example.demo.entity.WeatherResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "天气")
@Controller
@RequestMapping("")
public class WeatherController {

    public static Map<String, WeatherResponse> weatherResponseMap = new HashMap<>();

    @ApiOperation("根据城市获取天气")
    @GetMapping("/")
    @ResponseBody
    public Result<Weather> get(@RequestParam("cityName") String cityName) {
        if (weatherResponseMap.containsKey(cityName)) {
            Weather weather = weatherResponseMap.get(cityName).getData();
            return Result.success(weather);
        }
        return Result.failure();
    }
}
