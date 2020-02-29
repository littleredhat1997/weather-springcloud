package com.example.demo.controller;

import cn.hutool.core.convert.Convert;
import com.example.demo.base.PageResult;
import com.example.demo.base.Result;
import com.example.demo.dto.CreativeDto;
import com.example.demo.dto.PageDto;
import com.example.demo.entity.Creative;
import com.example.demo.service.CreativeService;
import com.example.demo.vo.CreativeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "推广创意")
@Controller
@RequestMapping("/creative")
public class CreativeController {

    @Autowired
    private CreativeService creativeService;

    @ApiOperation("获取计划")
    @GetMapping("/{id}")
    @ResponseBody
    public Result<CreativeVo> get(@PathVariable("id") Long id) {
        Creative creative = creativeService.get(id);
        CreativeVo creativeVo = Convert.convert(CreativeVo.class, creative);
        return Result.success(creativeVo);
    }

    @ApiOperation("获取计划列表")
    @GetMapping("")
    @ResponseBody
    public PageResult<List<CreativeVo>> getList(@Valid PageDto request) {
        Page<Creative> page = creativeService.getList(request);
        List<CreativeVo> creativeVoList = page.getContent().stream()
                .map(creative -> Convert.convert(CreativeVo.class, creative))
                .collect(Collectors.toList());
        return PageResult.success(creativeVoList, page.getTotalElements());
    }

    @ApiOperation("添加创意")
    @PostMapping("")
    @ResponseBody
    public Result<String> add(@Valid CreativeDto creativeDto) {
        creativeService.add(creativeDto);
        return Result.success();
    }

    @ApiOperation("修改创意")
    @PutMapping("/{id}")
    @ResponseBody
    public Result<String> update(@PathVariable("id") Long id, @Valid CreativeDto creativeDto) {
        creativeService.update(id, creativeDto);
        return Result.success();
    }

    @ApiOperation("删除创意")
    @DeleteMapping("/{id}")
    @ResponseBody
    public Result<String> delete(@PathVariable("id") Long id) {
        creativeService.delete(id);
        return Result.success();
    }
}
