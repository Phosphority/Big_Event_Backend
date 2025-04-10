package com.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Category {
    @NotNull(groups = updateCategory.class)
    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{3,10}$",message = "文章分类名称需要在3-10之间")
    private String categoryName;
    @NotEmpty
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{3,10}$",message = "文章分类名称需要在3-10之间")
    private String categoryAlias;
    private Integer createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public interface addCategory extends Default {}
    public interface updateCategory extends Default {}
}
