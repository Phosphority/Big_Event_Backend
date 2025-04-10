package com.backend.mapper;

import com.backend.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CategoryMapper {

    boolean batchDelete(List<Integer> ids);

    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time) " +
            "values(#{categoryName},#{categoryAlias},#{createUser},now(),now()) ")
    boolean add(Category category);

    @Select("select * from category " +
            "where create_user=#{createUser}")
    List<Category> getList(Integer createUser);
}
