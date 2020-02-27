package com.example.demo.qiniu.impl;

import cn.hutool.core.convert.Convert;
import com.example.demo.dao.PlanRepository;
import com.example.demo.dto.PlanDto;
import com.example.demo.entity.Plan;
import com.example.demo.qiniu.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> getList(Long userId) {
        return planRepository.findByUserId(userId);
    }

    @Override
    public void add(PlanDto planDto) {
        Plan plan = Convert.convert(Plan.class, planDto);
        planRepository.save(plan);
    }

    @Override
    public void update(Long planId, PlanDto planDto) {
        Plan plan = Convert.convert(Plan.class, planDto);
        plan.setId(planId);
        planRepository.save(plan);
    }

    @Override
    public void delete(Long planId) {
        planRepository.deleteById(planId);
    }
}
