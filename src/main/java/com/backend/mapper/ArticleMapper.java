package com.backend.mapper;

import com.backend.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},now(),now()) ")
    boolean add(Article article);

    @Update("update article " +
            "set title = #{title},content = #{content},cover_img = #{coverImg},state = #{state},category_id = #{categoryId},create_user = #{createUser},update_time = now()" +
            "where id = #{id}")
    boolean update(Article article);

    List<Article> getList(Integer createUser,Integer categoryId, String state);

    @Select("select * from article where id =#{id}")
    Article detail(Integer id);

    @Delete("delete from article where id = #{id}")
    boolean delete(Integer id);

    boolean batchDelete(List<Integer> ids);

}
