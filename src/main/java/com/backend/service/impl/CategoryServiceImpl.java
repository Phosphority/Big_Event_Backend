package com.backend.service.impl;

import com.backend.entity.Category;
import com.backend.entity.PageBean;
import com.backend.mapper.CategoryMapper;
import com.backend.service.CategoryService;
import com.backend.utils.ThreadLocalUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
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
    public PageBean<Category> getList(Integer pageNum, Integer pageSize) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categoryList = categoryMapper.getList(userId);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        return new PageBean<Category>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public boolean update(Category category) {

        return categoryMapper.update(category);
    }

    @Override
    public Category getDetail(Integer id) {
        return categoryMapper.getDetail(id);
    }

    @Override
    public boolean delete(Integer id) {
        return categoryMapper.delete(id);
    }
}





