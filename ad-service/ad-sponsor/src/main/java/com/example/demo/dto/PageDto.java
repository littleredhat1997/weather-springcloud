package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageDto {

    @ApiModelProperty(value = "页面", example = "0")
    Integer page = 1;

    @ApiModelProperty(value = "大小", example = "0")
    Integer size = 10;

    @ApiModelProperty(value = "关键词")
    String keyword = "";
}
