package com.example.weather.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;
}
