package com.backend.mapper;

import com.backend.entity.Category;
import org.apache.ibatis.annotations.*;
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

    @Update("update category " +
            "set category_name = #{categoryName},category_alias = #{categoryAlias},update_time = now() " +
            "where id = #{id}")
    boolean update(Category category);

    @Select("select * from category " +
            "where id=#{id}")
    Category getDetail(Integer id);

    @Delete("delete from category where id = #{id}")
    boolean delete(Integer id);
}
