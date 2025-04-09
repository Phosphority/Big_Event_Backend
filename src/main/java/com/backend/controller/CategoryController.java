package com.backend.controller;

import com.backend.entity.Category;
import com.backend.entity.Result;
import com.backend.entity.Test01;
import com.backend.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;


    @DeleteMapping("/batchDelete")
    public Result batchDelete(@RequestBody List<Test01> test01List) {

        System.out.println(test01List);
//        if(categoryService.batchDelete()){
//            return Result.success();
//        }
        return Result.error("删除失败");
    }


}
