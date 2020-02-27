package com.example.demo.qiniu;

import com.example.demo.dto.UnitDto;
import com.example.demo.entity.Unit;

import java.util.List;

public interface UnitService {

    List<Unit> getList(Long planId);

    void add(UnitDto unitDto);

    void update(Long unitId, UnitDto unitDto);

    void delete(Long unitId);
}
