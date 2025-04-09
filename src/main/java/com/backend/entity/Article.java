package com.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer categoryId;
    private Integer createUser;
    private String coverImg;
    private String state;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
}
