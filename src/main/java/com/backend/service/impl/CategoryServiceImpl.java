package com.backend.service.impl;

import com.backend.entity.Category;
import com.backend.entity.Result;
import com.backend.mapper.CategoryMapper;
import com.backend.service.CategoryService;
import com.backend.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    @Override
    public boolean batchDelete(List<Integer> ids) {
        return categoryMapper.batchDelete(ids);
    }

    @Override
    public boolean add(Category category) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        category.setCreateUser(userId);
        return categoryMapper.add(category);
    }

    @Override
    public List<Category> getList() {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");

        return categoryMapper.getList(userId);
    }
}





