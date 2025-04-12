package com.backend.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import com.backend.service.OssService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OssServiceImpl implements OssService {

    @Resource
    private OSS ossClient;

    @Value("${aliyun.oss.bucket-name}")
    private String bucketName;

    @Override
    public String uploadFile(String objectName, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, file);
        ossClient.putObject(putObjectRequest);
        return "https://"+bucketName+"."+"oss-cn-shanghai.aliyuncs.com"+"/"+objectName;
    }
}
