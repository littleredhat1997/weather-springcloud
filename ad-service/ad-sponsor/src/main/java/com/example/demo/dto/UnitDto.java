package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UnitDto {

    // 定向 TODO

    @ApiModelProperty(value = "所属计划", example = "0")
    @NotNull(message = "所属计划不能为空")
    private Long planId;

    @ApiModelProperty(value = "广告版位", example = "0")
    @NotNull(message = "广告版位不能为空")
    private Integer position;

    @ApiModelProperty(value = "开始时间")
    @NotNull(message = "开始时间不能为空")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @NotNull(message = "结束时间不能为空")
    private Date endTime;

    @ApiModelProperty(value = "出价")
    @NotNull(message = "出价不能为空")
    private Double price;

    @ApiModelProperty(value = "单元名字")
    @NotNull(message = "单元名字不能为空")
    private String name;

    private Boolean enable = false;
}
