package com.backend.controller;

import com.backend.entity.Result;
import com.backend.service.OssService;
import com.backend.utils.UUIDUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Resource
    private OssService ossService;

    @PostMapping
    public Result<String> upload(@RequestParam("file") MultipartFile file) {

        try{                                 // 1.这一段是获取系统的临时目录C:\Users\用户名\AppData\Local\Temp\
            File tempFile = new File(System.getProperty("java.io.tmpdir")+"/"+file.getOriginalFilename());
            // 3.这里是文件最终组合而成的路径，可能是这样的/tmp/test.jpg                  // 2.这一段代码可以获取文件的原始名，比如miku.jpg
            // 4.这里是将前端上传的文件保存在临时的路径中,类似于先将文件转移到一个临时的路径中，然后再从这个临时的路径传输文件到服务器;transferTo:传输，转移到
            file.transferTo(tempFile);
                            // 5.使用文件的原始名称作为上传服务器的唯一标识可能会遇到名称相同的文件发生覆盖的情况，所以这里使用UUID作为上传到服务器的名称
            String fileUrl = ossService.uploadFile(UUIDUtil.getUUID(Objects.requireNonNull(file.getOriginalFilename())), tempFile);
            tempFile.delete();
            return Result.success(fileUrl);
        }catch (IOException e){
            e.printStackTrace();
            return Result.error("fail");
        }
    }
}
