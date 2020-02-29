package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// 推广单元
@Data
@Entity
@Table(name = "unit")
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "plan_id", nullable = false)
    private Long planId; // 所属计划

    // 定向 TODO

    @Column(name = "position", nullable = false)
    private Integer position; // 广告版位

    @Column(name = "start_time", nullable = false)
    private Date startTime; // 开始时间

    @Column(name = "end_time", nullable = false)
    private Date endTime; // 结束时间

    @Column(name = "price", nullable = false)
    private Double price; // 出价

    @Column(name = "name", nullable = false)
    private String name; // 单元名字

    @Column(name = "enable", nullable = false)
    private Boolean enable = false;

    @Column(name = "exposure", nullable = false)
    private Long exposure = 0L;

    @Column(name = "click", nullable = false)
    private Long click = 0L;

    private Date createTime;

    private Date updateTime;
}
