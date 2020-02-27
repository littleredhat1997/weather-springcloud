package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

// 推广创意：创意形式、上传创意
@Data
@Entity
public class Creative implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long unitId; // 所属单元

    @Column(nullable = false)
    private Integer materialType; // 物料类型（图片、视频、创新形式）

    @Column(nullable = false)
    private Integer subType; // 物料子类型

    @Column(nullable = false)
    private String url; // 物料地址

    @Column(nullable = false)
    private String title; // 广告标题

    @Column(nullable = false)
    private String desc; // 广告描述

    @Column(nullable = false)
    private Integer auditStatus; // 审核状态 TODO

    @Column(nullable = false)
    private String name; // 创意名称

    @Column(nullable = false)
    private Integer status;

    private Date createTime;

    private Date updateTime;
}
