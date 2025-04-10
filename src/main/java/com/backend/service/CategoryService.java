package com.backend.service;

import com.backend.entity.Category;
import com.backend.entity.PageBean;

import java.util.List;

public interface CategoryService {

    boolean batchDelete(List<Integer> ids);

    boolean add(Category category);

    PageBean<Category> getList(Integer pageNum, Integer pageSize);

    boolean update(Category category);

    Category getDetail(Integer id);

    boolean delete(Integer id);
}
