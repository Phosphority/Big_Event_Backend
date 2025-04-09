package com.backend.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    boolean batchDelete(List<Integer> ids);
}
