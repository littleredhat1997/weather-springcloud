package com.example.weather.service.client;

import com.example.weather.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CityClientHystrix implements CityClient {

    @Override
    public List<City> listCity() throws Exception {
        log.error("熔断器！！！");
        return new ArrayList<>();
    }
}
