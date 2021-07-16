package com.image.image.controller;

import com.image.image.service.FileLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("file-system")
public class FileSystemImageController {
    @Autowired
    FileLocationService fileLocationService;

    @PostMapping("/image")
    String uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        return fileLocationService.save(file.getBytes(), StringUtils.cleanPath(file.getOriginalFilename()));
    }

    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    FileSystemResource downloadImage(@PathVariable String imageId) throws Exception {
        return fileLocationService.find(imageId);
    }
    @PostMapping("/profile/pic")
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
        //MultipartFile multiFile = new MultipartFile(); //File object passed from the front end


        // Logger.info("HIT -/upload | File Name : {}", multipartFile.getOriginalFilename());
        return fileLocationService.uploadimage(file);
    }
}
