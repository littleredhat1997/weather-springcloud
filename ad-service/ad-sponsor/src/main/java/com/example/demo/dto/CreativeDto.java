package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreativeDto {

    @ApiModelProperty(value = "所属单元", example = "0")
    @NotNull(message = "所属单元不能为空")
    private Long unitId;

    @ApiModelProperty(value = "物料类型", example = "0")
    @NotNull(message = "物料类型不能为空")
    private Integer materialType;

    @ApiModelProperty(value = "物料子类型", example = "0")
    @NotNull(message = "物料子类型不能为空")
    private Integer subType;

    @ApiModelProperty(value = "物料地址")
    @NotNull(message = "物料地址不能为空")
    private String url;

    @ApiModelProperty(value = "广告标题")
    @NotNull(message = "广告标题不能为空")
    private String title;

    @ApiModelProperty(value = "广告描述")
    @NotNull(message = "广告描述不能为空")
    private String content;

    @ApiModelProperty(value = "创意名字")
    @NotNull(message = "创意名字不能为空")
    private String name;

    private Boolean enable;
}
