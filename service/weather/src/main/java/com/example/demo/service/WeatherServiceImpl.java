package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.WeatherResponse;
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
    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_URI + cityName;
        return doGetWeather(url);
    }

    private WeatherResponse doGetWeather(String url) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            String result = responseEntity.getBody();
            return JSONObject.parseObject(result, WeatherResponse.class);
        }
        return null;
    }
}
