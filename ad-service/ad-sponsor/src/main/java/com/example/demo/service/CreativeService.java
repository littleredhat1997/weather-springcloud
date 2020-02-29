package com.example.demo.service;

import com.example.demo.dto.CreativeDto;
import com.example.demo.dto.PageDto;
import com.example.demo.entity.Creative;
import org.springframework.data.domain.Page;

public interface CreativeService {

    Creative get(Long creativeId);

    Page<Creative> getList(PageDto request);

    void add(CreativeDto creativeDto);

    void update(Long creativeId, CreativeDto creativeDto);

    void delete(Long creativeId);
}
