package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UnitDto {

    private Long userId = 2020L; // 所属用户 TODO

    @ApiModelProperty(value = "推广目标")
    @NotNull(message = "推广目标不能为空")
    private Integer target;

    @ApiModelProperty(value = "日限额")
    @NotNull(message = "日限额不能为空")
    private Integer limit;

    @ApiModelProperty(value = "投放模式")
    @NotNull(message = "投放模式不能为空")
    private Integer mode;

    @ApiModelProperty(value = "计划名称")
    @NotNull(message = "计划名称不能为空")
    private String name;

    private Boolean status = false;
}
