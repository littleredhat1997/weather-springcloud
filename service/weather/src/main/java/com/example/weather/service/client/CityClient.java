package com.example.weather.service.client;

import com.example.weather.entity.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "city", fallback = CityClientHystrix.class)
public interface CityClient {

    @GetMapping(value = "/cities")
    List<City> listCity() throws Exception;
}
