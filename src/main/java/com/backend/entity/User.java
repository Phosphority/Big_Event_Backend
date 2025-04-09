package com.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    @Nullable
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    @Nullable
    @Pattern(regexp = "^\\S{1,10}$")
    @NotEmpty(message = "nickname不能为空")
    private String nickname;
    @Email(message = "不是一个合法的邮箱地址")
    @NotEmpty
    private String email;
    @Nullable
    @URL
    private String userPic;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // JsonFormat设置的是返回的Json数据的格式
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}












