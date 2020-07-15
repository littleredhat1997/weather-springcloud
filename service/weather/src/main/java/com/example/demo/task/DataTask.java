package com.example.demo.task;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.WeatherController;
import com.example.demo.entity.City;
import com.example.demo.entity.Weather;
import com.example.demo.service.CityService;
import com.example.demo.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class DataTask {

    @Autowired
    private WeatherService weatherService;

    @Resource
    private CityService cityService;

    @Scheduled(fixedRate = 1800000) // 1800s
    public void weatherDataSync() {
        try {
            List<City> cityList = cityService.listCity();
            for (City city : cityList) {
                String cityName = city.getCityName();
                Weather weather = weatherService.getDataByCityName(cityName);
                if (weather == null) continue;
                WeatherController.weatherResponseMap.put(cityName, weather);
                log.info(cityName + ":" + JSON.toJSONString(weather));
            }
        } catch (Exception e) {
            log.error("解析失败：", e);
        }
    }
}
