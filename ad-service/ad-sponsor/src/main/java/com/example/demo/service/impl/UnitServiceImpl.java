package com.example.demo.qiniu.impl;

import cn.hutool.core.convert.Convert;
import com.example.demo.dao.UnitRepository;
import com.example.demo.dto.UnitDto;
import com.example.demo.entity.Unit;
import com.example.demo.qiniu.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public List<Unit> getList(Long planId) {
        return unitRepository.findByPlanId(planId);
    }

    @Override
    public void add(UnitDto unitDto) {
        Unit unit = Convert.convert(Unit.class, unitDto);
        unitRepository.save(unit);
    }

    @Override
    public void update(Long unitId, UnitDto unitDto) {
        Unit unit = Convert.convert(Unit.class, unitDto);
        unit.setId(unitId);
        unitRepository.save(unit);
    }

    @Override
    public void delete(Long unitId) {
        unitRepository.deleteById(unitId);
    }
}
