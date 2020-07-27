package com.example.weather.task;

import com.alibaba.fastjson.JSON;
import com.example.weather.controller.WeatherController;
import com.example.weather.entity.City;
import com.example.weather.entity.Weather;
import com.example.weather.service.client.CityClient;
import com.example.weather.service.WeatherService;
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
    private CityClient cityClient;

    @Scheduled(fixedRate = 1800000) // 1800s
    public void weatherDataSync() {
        try {
            List<City> cityList = cityClient.listCity();
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
