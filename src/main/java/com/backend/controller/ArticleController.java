package com.backend.controller;

import com.backend.entity.Article;
import com.backend.entity.PageBean;
import com.backend.entity.Result;
import com.backend.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PostMapping
    public Result add(@Validated(Article.addArticle.class) @RequestBody Article article) {

        if(articleService.add(article)){
            return Result.success();
        }
        return Result.error("fail");
    }

    @PutMapping
    public Result update(@Validated(Article.updateArticle.class) @RequestBody Article article) {

        if(articleService.update(article)){
            return Result.success();
        }
        return Result.error("fail");
    }

    @GetMapping
    public Result<PageBean<Article>> getList(
            @RequestParam(required = true) Integer pageNum,
            @RequestParam(required = true) Integer pageSize,
            @Validated @RequestParam Integer categoryId,
            @Validated @RequestParam String state
    ) {

        PageBean<Article> articlePageBean = articleService.getList(pageNum,pageSize,categoryId,state);
        if(articlePageBean != null){
            return Result.success(articlePageBean);
        }
        return Result.error("fail");
    }

    @GetMapping("/detail")
    public Result<Article> detail(@RequestParam Integer id) {

        Article article = articleService.detail(id);
        if(article != null){
            return Result.success(article);
        }
        return Result.error("fail");
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {

        if(articleService.delete(id)){
            return Result.success();
        }
        return Result.error("fail");
    }

    @DeleteMapping("/batchDelete")
    public Result batchDelete(@RequestBody List<Integer> ids) {

        if(articleService.batchDelete(ids)){
            return Result.success();
        }
        return Result.error("fail");
    }
}


















