package com.backend.service;

import com.backend.entity.Category;

import java.util.List;

public interface CategoryService {
    boolean batchDelete(List<Integer> ids);

    boolean add(Category category);

    List<Category> getList();
}
