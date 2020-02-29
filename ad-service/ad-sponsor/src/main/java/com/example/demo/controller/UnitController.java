package com.example.demo.controller;

import cn.hutool.core.convert.Convert;
import com.example.demo.base.PageResult;
import com.example.demo.base.Result;
import com.example.demo.dto.PageDto;
import com.example.demo.dto.UnitDto;
import com.example.demo.entity.Unit;
import com.example.demo.service.UnitService;
import com.example.demo.vo.UnitVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "推广单元")
@Controller
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @ApiOperation("获取单元")
    @GetMapping("/{id}")
    @ResponseBody
    public Result<UnitVo> get(@PathVariable("id") Long id) {
        Unit unit = unitService.get(id);
        UnitVo unitVo = Convert.convert(UnitVo.class, unit);
        return Result.success(unitVo);
    }

    @ApiOperation("获取单元列表")
    @GetMapping("")
    @ResponseBody
    public Result<List<UnitVo>> getList(@Valid PageDto request) {
        Page<Unit> page = unitService.getList(request);
        List<UnitVo> unitVoList = page.getContent().stream()
                .map(unit -> Convert.convert(UnitVo.class, unit))
                .collect(Collectors.toList());
        return PageResult.success(unitVoList, page.getTotalElements());
    }

    @ApiOperation("添加单元")
    @PostMapping("")
    @ResponseBody
    public Result<String> add(@Valid UnitDto unitDto) {
        unitService.add(unitDto);
        return Result.success();
    }

    @ApiOperation("修改单元")
    @PutMapping("/{id}")
    @ResponseBody
    public Result<String> update(@PathVariable("id") Long id, @Valid UnitDto unitDto) {
        unitService.update(id, unitDto);
        return Result.success();
    }

    @ApiOperation("删除单元")
    @DeleteMapping("/{id}")
    @ResponseBody
    public Result<String> delete(@PathVariable("id") Long id) {
        unitService.delete(id);
        return Result.success();
    }
}
