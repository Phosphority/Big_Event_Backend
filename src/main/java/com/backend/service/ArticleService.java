package com.backend.service;


import com.backend.entity.Article;
import com.backend.entity.PageBean;

import java.util.List;

public interface ArticleService{
    boolean add(Article article);

    boolean update(Article article);

    PageBean<Article> getList(Integer pageNum, Integer pageSize,Integer categoryId,String state);

    Article detail(Integer id);

    boolean delete(Integer id);

    boolean batchDelete(List<Integer> ids);
}
