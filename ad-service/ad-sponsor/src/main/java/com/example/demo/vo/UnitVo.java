package com.example.demo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UnitVo {

    private Long id;

    private Long planId;

    private Integer position;

    private Date startTime;

    private Date endTime;

    private Double price;

    private String name;

    private Boolean enable;

    private Long exposure;

    private Long click;

    private Date createTime;

    private Date updateTime;
}
