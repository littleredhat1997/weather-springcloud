package com.example.demo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CreativeVo {

    private Long id;

    private Long unitId;

    private Integer materialType;

    private Integer subType;

    private String url;

    private String title;

    private String content;

    private String name;

    private Boolean enable;

    private Long exposure;

    private Long click;

    private Date createTime;

    private Date updateTime;
}
