package com.image.image.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import com.image.image.entity.Image;
import com.image.image.repository.FileSystemRepository;
import com.image.image.repository.ImageDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class FileLocationService {
    @Autowired(required=false)
    FileSystemRepository fileSystemRepository;
    @Autowired(required=false)
    ImageDbRepository imageDbRepository;

    public String save(byte[] bytes, String imageName) throws Exception {
        String location = fileSystemRepository.save(bytes, imageName);
        return imageDbRepository.save(new Image(imageName, location))
                .getName();
    }
    public FileSystemResource find(String imageId) {
        Image image = imageDbRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return fileSystemRepository.findInFileSystem(image.getLocation());
    }

    public String uploadimage (MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf("."));

        File file1 = null;
        try {

            file1 = File.createTempFile(fileName, prefix);
            file.transferTo(file1);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // After operating the above files, you need to delete the temporary files generated in the root directory
            File f = new File(file1.toURI());
            // f.delete();
        }
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "one-gate",
                "api_key", "327292825896617",
                "api_secret", "9EeLB-gb7h2srACtRmjLXm5G3iY",
                "secure", true));
        //File file = new File("img1.png");
        Map uploadResult = cloudinary.uploader().upload(file1, ObjectUtils.emptyMap());
        System.out.println(uploadResult.get("url"));
        return imageDbRepository.save(new Image(fileName,(String)uploadResult.get("url"))).getName();
    }
    }




