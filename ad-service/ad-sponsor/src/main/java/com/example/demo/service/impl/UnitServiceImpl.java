package com.example.demo.service.impl;

import cn.hutool.core.convert.Convert;
import com.example.demo.dao.UnitRepository;
import com.example.demo.dto.PageDto;
import com.example.demo.dto.UnitDto;
import com.example.demo.entity.Unit;
import com.example.demo.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Unit get(Long unitId) {
        return unitRepository.getOne(unitId);
    }

    @Override
    public Page<Unit> getList(PageDto request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        if (!StringUtils.isEmpty(request.getKeyword())) {
            String keyword = '%' + request.getKeyword() + '%';
            return unitRepository.findPageByName(keyword, pageable);
        } else {
            return unitRepository.findAll(pageable);
        }
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
