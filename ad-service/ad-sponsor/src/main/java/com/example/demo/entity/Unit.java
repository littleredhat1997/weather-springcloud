package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

// 推广单元：目标详情、定向、广告版位、排期和出价
@Data
@Entity
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long planId; // 所属计划

    @Column(nullable = false)
    private String content; // 目标详情

    // 定向 TODO

    @Column(nullable = false)
    private Integer position; // 广告版位 PositionEnum

    @Column(nullable = false)
    private Date startTime; // 开始时间

    @Column(nullable = false)
    private Date endTime; // 结束时间

    @Column(nullable = false)
    private Double price; // 出价

    @Column(nullable = false)
    private String name; // 单元名称

    @Column(nullable = false)
    private Integer status;

    private Date createTime;

    private Date updateTime;
}
