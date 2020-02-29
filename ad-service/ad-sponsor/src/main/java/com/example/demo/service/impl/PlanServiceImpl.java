package com.example.demo.service.impl;

import cn.hutool.core.convert.Convert;
import com.example.demo.dao.PlanRepository;
import com.example.demo.dto.PageDto;
import com.example.demo.dto.PlanDto;
import com.example.demo.entity.Plan;
import com.example.demo.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public Plan get(Long planId) {
        return planRepository.getOne(planId);
    }

    @Override
    public Page<Plan> getList(PageDto request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        if (!StringUtils.isEmpty(request.getKeyword())) {
            String keyword = '%' + request.getKeyword() + '%';
            return planRepository.findPageByName(keyword, pageable);
        } else {
            return planRepository.findAll(pageable);
        }
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
