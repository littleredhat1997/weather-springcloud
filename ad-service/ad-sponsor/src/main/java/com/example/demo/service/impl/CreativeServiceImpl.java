package com.example.demo.qiniu.impl;

import cn.hutool.core.convert.Convert;
import com.example.demo.dao.CreativeRepository;
import com.example.demo.dto.CreativeDto;
import com.example.demo.entity.Creative;
import com.example.demo.qiniu.CreativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreativeServiceImpl implements CreativeService {

    @Autowired
    private CreativeRepository creativeRepository;

    @Override
    public List<Creative> getList(Long unitId) {
        return creativeRepository.findByUnitId(unitId);
    }

    @Override
    public void add(CreativeDto creativeDto) {
        Creative creative = Convert.convert(Creative.class, creativeDto);
        creativeRepository.save(creative);
    }

    @Override
    public void update(Long creativeId, CreativeDto creativeDto) {
        Creative creative = Convert.convert(Creative.class, creativeDto);
        creative.setId(creativeId);
        creativeRepository.save(creative);
    }

    @Override
    public void delete(Long creativeId) {
        creativeRepository.deleteById(creativeId);
    }
}
