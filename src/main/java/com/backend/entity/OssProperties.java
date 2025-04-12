package com.backend.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss") // 用于将配置文件中以某个前缀开头的属性自动绑定到 Java Bean 的字段上,驼峰 vs 横线会自动转换,必须要有getter和setter方法
public class OssProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
