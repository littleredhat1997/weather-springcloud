package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PlanDto {

    @ApiModelProperty(value = "计划名字")
    @NotNull(message = "计划名字不能为空")
    private String name;

    private Boolean enable = false;
}
