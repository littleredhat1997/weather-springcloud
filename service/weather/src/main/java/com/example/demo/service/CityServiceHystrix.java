package com.example.demo.service;

import com.example.demo.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CityServiceHystrix implements CityService {

    @Override
    public List<City> listCity() throws Exception {
        log.error("熔断器！！！");
        return null;
    }
}
