package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

// 推广计划：推广目标、计划设置
@Data
@Entity
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long userId; // 所属用户

    @Column(nullable = false)
    private Integer target; // 推广目标 TargetEnum

    @Column(nullable = false)
    private Integer limit; // 日限额

    @Column(nullable = false)
    private Integer mode; // 投放模式 ModeEnum

    @Column(nullable = false)
    private String name; // 计划名称

    @Column(nullable = false)
    private Integer status;

    private Date createTime;

    private Date updateTime;
}
