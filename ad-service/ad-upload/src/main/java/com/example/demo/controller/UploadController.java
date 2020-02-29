package com.example.demo.controller;

import com.example.demo.base.Result;
import com.example.demo.base.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Api(tags = "上传文件")
@Controller
@RequestMapping("")
public class UploadController {

    private static final String UPLOADED_FOLDER = "D://upload//";

    @ApiOperation("上传文件")
    @PostMapping("")
    @ResponseBody
    public Result<String> upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.failure(Status.FILE_UPLOAD_EMPTY);
        } else {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                return Result.success(path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Result.failure(Status.FILE_UPLOAD_ERROR);
    }
}
