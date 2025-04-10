package com.backend.controller;

import com.backend.entity.Category;
import com.backend.entity.Result;
import com.backend.entity.Test01;
import com.backend.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody Category category) {

        if(categoryService.add(category)){
            return Result.success();
        }
        return Result.error("fail");
    }

    @GetMapping
    public Result<List<Category>> getList() {

        List<Category> categoryList = categoryService.getList();
        if(categoryList == null || categoryList.isEmpty()){
            return Result.success(categoryList);
        }
        return Result.error("fail");
    }


    @DeleteMapping("/batchDelete")
    public Result batchDelete(@RequestBody List<Test01> test01List) {

        System.out.println(test01List);
//        if(categoryService.batchDelete()){
//            return Result.success();
//        }
        return Result.error("删除失败");
    }
}
