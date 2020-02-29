package com.example.demo.service.impl;

import cn.hutool.core.convert.Convert;
import com.example.demo.dao.CreativeRepository;
import com.example.demo.dto.CreativeDto;
import com.example.demo.dto.PageDto;
import com.example.demo.entity.Creative;
import com.example.demo.service.CreativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CreativeServiceImpl implements CreativeService {

    @Autowired
    private CreativeRepository creativeRepository;

    @Override
    public Creative get(Long creativeId) {
        return creativeRepository.getOne(creativeId);
    }

    @Override
    public Page<Creative> getList(PageDto request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        if (!StringUtils.isEmpty(request.getKeyword())) {
            String keyword = '%' + request.getKeyword() + '%';
            return creativeRepository.findPageByName(keyword, pageable);
        } else {
            return creativeRepository.findAll(pageable);
        }
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
