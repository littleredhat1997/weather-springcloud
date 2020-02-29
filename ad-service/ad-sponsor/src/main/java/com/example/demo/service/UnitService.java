package com.example.demo.service;

import com.example.demo.dto.PageDto;
import com.example.demo.dto.UnitDto;
import com.example.demo.entity.Unit;
import org.springframework.data.domain.Page;

public interface UnitService {

    Unit get(Long unitId);

    Page<Unit> getList(PageDto request);

    void add(UnitDto unitDto);

    void update(Long unitId, UnitDto unitDto);

    void delete(Long unitId);
}
