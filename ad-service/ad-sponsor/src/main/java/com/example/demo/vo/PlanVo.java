package com.example.demo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PlanVo {

    private Long id;

    private String name;

    private Boolean enable;

    private Long exposure;

    private Long click;

    private Date createTime;

    private Date updateTime;
}
