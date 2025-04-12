package com.backend.service.impl;

import com.backend.entity.Article;
import com.backend.entity.PageBean;
import com.backend.mapper.ArticleMapper;
import com.backend.service.ArticleService;
import com.backend.utils.ThreadLocalUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public boolean add(Article article) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        article.setCreateUser(userId);
        return articleMapper.add(article);
    }

    @Override
    public boolean update(Article article) {
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        article.setCreateUser(userId);
        return articleMapper.update(article);
    }

    @Override
    public PageBean<Article> getList(Integer pageNum, Integer pageSize,Integer categoryId,String state) {

        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        // 1.启动分页
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articleList = articleMapper.getList(userId,categoryId,state);
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        return new PageBean<Article>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Article detail(Integer id) {
        return articleMapper.detail(id);
    }

    @Override
    public boolean delete(Integer id) {
        return articleMapper.delete(id);
    }

    @Override
    public boolean batchDelete(List<Integer> ids) {
        return articleMapper.batchDelete(ids);
    }
}




















