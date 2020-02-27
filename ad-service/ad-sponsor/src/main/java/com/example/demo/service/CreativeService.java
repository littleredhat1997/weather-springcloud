package com.example.demo.qiniu;

import com.example.demo.dto.CreativeDto;
import com.example.demo.entity.Creative;

import java.util.List;

public interface CreativeService {

    List<Creative> getList(Long unitId);

    void add(CreativeDto creativeDto);

    void update(Long creativeId, CreativeDto creativeDto);

    void delete(Long creativeId);
}
