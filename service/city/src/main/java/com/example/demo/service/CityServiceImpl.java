package com.example.demo.service;

import com.example.demo.entity.City;
import com.example.demo.entity.CityList;
import com.example.demo.utils.XmlBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Service
public class CityServiceImpl implements CityService {

    public static final String FILE = "citylist.xml";

    @Override
    public List<City> listCity() throws Exception {
        Resource resource = new ClassPathResource(FILE);
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder buffer = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        CityList cityList = (CityList) XmlBuilder.xmlToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
