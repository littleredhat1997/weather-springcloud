package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// 推广计划
@Data
@Entity
@Table(name = "plan")
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name; // 计划名字

    @Column(name = "enable", nullable = false)
    private Boolean enable = false;

    @Column(name = "exposure", nullable = false)
    private Long exposure = 0L;

    @Column(name = "click", nullable = false)
    private Long click = 0L;

    private Date createTime;

    private Date updateTime;
}
