package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// 推广创意
@Data
@Entity
@Table(name = "creative")
public class Creative implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long unitId; // 所属单元

    @Column(name = "material_type", nullable = false)
    private Integer materialType; // 物料类型（图片、视频、创新形式）

    @Column(name = "sub_type", nullable = false)
    private Integer subType; // 物料子类型

    @Column(name = "url", nullable = false)
    private String url; // 物料地址

    @Column(name = "title", nullable = false)
    private String title; // 广告标题

    @Column(name = "content", nullable = false)
    private String content; // 广告描述

    @Column(name = "name", nullable = false)
    private String name; // 创意名字

    @Column(name = "enable", nullable = false)
    private Boolean enable = false;

    @Column(name = "exposure", nullable = false)
    private Long exposure = 0L;

    @Column(name = "click", nullable = false)
    private Long click = 0L;

    private Date createTime;

    private Date updateTime;
}
