package com.example.weather.service;

import com.example.weather.entity.Weather;

public interface WeatherService {

    Weather getDataByCityName(String cityName);
}
