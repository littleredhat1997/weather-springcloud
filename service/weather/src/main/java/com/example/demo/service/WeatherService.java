package com.example.demo.service;

import com.example.demo.entity.Weather;

public interface WeatherService {

    Weather getDataByCityName(String cityName);
}
