package com.example.demo.controller;

import com.example.demo.base.Result;
import com.example.demo.dto.PlanDto;
import com.example.demo.entity.Plan;
import com.example.demo.service.PlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "推广计划")
@Controller
@RequestMapping("/plan")
public class UnitController {

    @Autowired
    private PlanService planService;

    @ApiOperation("获取计划列表")
    @GetMapping("/{id}")
    @ResponseBody
    public Result<List<Plan>> get(@PathVariable("id") Long id) {
        List<Plan> planList = planService.getList(id);
        return Result.success(planList);
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
    public Result<String> update(@PathVariable("id") Long id,
                                 @Valid PlanDto planDto) {
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
