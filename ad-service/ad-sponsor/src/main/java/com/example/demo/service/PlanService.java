package com.example.demo.service;

import com.example.demo.dto.PageDto;
import com.example.demo.dto.PlanDto;
import com.example.demo.entity.Plan;
import org.springframework.data.domain.Page;

public interface PlanService {

    Plan get(Long planId);

    Page<Plan> getList(PageDto request);

    void add(PlanDto planDto);

    void update(Long planId, PlanDto planDto);

    void delete(Long planId);
}
