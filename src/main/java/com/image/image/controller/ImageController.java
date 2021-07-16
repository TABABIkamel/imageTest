package com.image.image.controller;



import com.image.image.entity.Image;
import com.image.image.repository.ImageDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ImageController {
    @Autowired
    ImageDbRepository imageDbRepository;
   /*
    @PostMapping
    Long uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        Image dbImage = new Image();
        dbImage.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        dbImage.setContent(file.getBytes());
        return imageDbRepository.save(dbImage)
                .getId();
    }
    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    ByteArrayResource downloadImage(@PathVariable Long imageId) {
        byte[] image = imageDbRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getContent();
        return new ByteArrayResource(image);
    }

    */
}
