package com.example.demo.service;

import com.example.demo.entity.WeatherResponse;

public interface WeatherService {

    WeatherResponse getDataByCityName(String cityName);
}
