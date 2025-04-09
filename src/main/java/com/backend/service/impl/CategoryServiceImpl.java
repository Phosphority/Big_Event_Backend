package com.backend.service.impl;

import com.backend.mapper.CategoryMapper;
import com.backend.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    @Override
    public boolean batchDelete(List<Integer> ids) {

        return categoryMapper.batchDelete(ids);
    }
}
