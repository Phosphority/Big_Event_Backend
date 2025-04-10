package com.backend.controller;

import com.backend.entity.Category;
import com.backend.entity.PageBean;
import com.backend.entity.Result;
import com.backend.entity.Test01;
import com.backend.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PostMapping
    public Result add(@Validated(Category.addCategory.class) @RequestBody Category category) {

        if(categoryService.add(category)){
            return Result.success();
        }
        return Result.error("fail");
    }

    @GetMapping
    public Result<PageBean<Category>> getList(
            @RequestParam(required = true) Integer pageNum,
            @RequestParam(required = true) Integer pageSize
    ) {

        PageBean<Category> categoryPageBean = categoryService.getList(pageNum,pageSize);
        if(categoryPageBean != null){
            return Result.success(categoryPageBean);
        }
        return Result.error("fail");
    }

    @PutMapping
    public Result update(@Validated(Category.updateCategory.class) @RequestBody Category category) {

        if(categoryService.update(category)){
            return Result.success();
        }
        return Result.error("fail");
    }

    @GetMapping("/detail")
    public Result<Category> getDetail(@RequestParam Integer id) {

        Category category = categoryService.getDetail(id);
        if(category != null){
            return Result.success(category);
        }
        return Result.error("fail");
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {

        if(categoryService.delete(id)){
            return Result.success();
        }
        return Result.error("fail");
    }

    @DeleteMapping("/batchDelete")
    public Result batchDelete(@RequestBody List<Integer> ids) {

        if(categoryService.batchDelete(ids)){
            return Result.success();
        }
        return Result.error("fail");
    }
}
