package com.example.demo.service;

import com.example.demo.entity.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("city")
public interface CityClient {

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    List<City> listCity() throws Exception;
}
