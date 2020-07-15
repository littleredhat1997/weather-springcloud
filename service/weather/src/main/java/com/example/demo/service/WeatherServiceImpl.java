package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Weather;
import com.example.demo.entity.WeatherResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?city=";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getDefault") // 熔断器！！！
    public Weather getDataByCityName(String cityName) {
        String url = WEATHER_URI + cityName;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            String result = responseEntity.getBody();
            WeatherResponse weatherResponse = JSONObject.parseObject(result, WeatherResponse.class);
            if (weatherResponse.getStatus() == 1000) {
                return weatherResponse.getData();
            }
        }
        return null;
    }

    public Weather getDefault(String cityName) {
        log.error("熔断器！！！" + cityName);
        return null;
    }
}
