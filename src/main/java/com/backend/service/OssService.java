package com.backend.service;

import java.io.File;

public interface OssService {
    String uploadFile(String objectName, File file);
}
