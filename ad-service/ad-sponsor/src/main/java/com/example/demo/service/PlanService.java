package com.example.demo.qiniu;

import com.example.demo.dto.PlanDto;
import com.example.demo.entity.Plan;

import java.util.List;

public interface PlanService {

    List<Plan> getList(Long userId);

    void add(PlanDto planDto);

    void update(Long planId, PlanDto planDto);

    void delete(Long planId);
}
