package com.backend.entity;

import com.backend.annotation.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Article {
    @NotNull(groups = updateArticle.class)
    private Integer id;
    @NotEmpty(message = "文章标题不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{3,16}$",message = "文章标题需要在3-16之间")
    private String title;
    private String content;
    @NotNull(message = "文章分类不能为空")
    private Integer categoryId;
    private Integer createUser;
    @URL(message = "图片必须为url的格式")
    private String coverImg;
    @NotEmpty(message = "文章状态不能为空")
    @State
    private String state;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private LocalDateTime updateTime;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private LocalDateTime deleteTime;

    public interface addArticle extends Default {}
    public interface updateArticle extends Default {}
}
