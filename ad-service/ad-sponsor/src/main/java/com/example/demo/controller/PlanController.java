package com.example.demo.controller;

import cn.hutool.core.convert.Convert;
import com.example.demo.base.PageResult;
import com.example.demo.base.Result;
import com.example.demo.dto.PageDto;
import com.example.demo.dto.PlanDto;
import com.example.demo.entity.Plan;
import com.example.demo.service.PlanService;
import com.example.demo.vo.PlanVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "推广计划")
@Controller
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @ApiOperation("获取计划")
    @GetMapping("/{id}")
    @ResponseBody
    public Result<PlanVo> get(@PathVariable("id") Long id) {
        Plan plan = planService.get(id);
        PlanVo planVo = Convert.convert(PlanVo.class, plan);
        return Result.success(planVo);
    }

    @ApiOperation("获取计划列表")
    @GetMapping("")
    @ResponseBody
    public PageResult<List<PlanVo>> getList(@Valid PageDto request) {
        Page<Plan> page = planService.getList(request);
        List<PlanVo> planVoList = page.getContent().stream()
                .map(plan -> Convert.convert(PlanVo.class, plan))
                .collect(Collectors.toList());
        return PageResult.success(planVoList, page.getTotalElements());
    }

    @ApiOperation("添加计划")
    @PostMapping("")
    @ResponseBody
    public Result<String> add(@Valid PlanDto planDto) {
        planService.add(planDto);
        return Result.success();
    }

    @ApiOperation("修改计划")
    @PutMapping("/{id}")
    @ResponseBody
    public Result<String> update(@PathVariable("id") Long id, @Valid PlanDto planDto) {
        planService.update(id, planDto);
        return Result.success();
    }

    @ApiOperation("删除计划")
    @DeleteMapping("/{id}")
    @ResponseBody
    public Result<String> delete(@PathVariable("id") Long id) {
        planService.delete(id);
        return Result.success();
    }
}
