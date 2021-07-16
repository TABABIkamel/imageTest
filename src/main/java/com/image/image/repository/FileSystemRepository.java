package com.image.image.repository;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Repository
public class FileSystemRepository {
    //String RESOURCES_DIR = FileSystemRepository.class.getResource("/repository").getPath();
    //String RESOURCES_DIR = FileSystemRepository.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    public String save(byte[] content, String imageName) throws Exception {
        Path newFile = Paths.get("C:\\Users\\TB kml\\Desktop\\storeImage\\"+new Date().getTime() +"_"+ imageName);
        //String textPath="C:\\Users\\TB kml\\Desktop\\storeImage";
        //Path path = Paths.get(textPath);
        //Files.createDirectories(path.getParent());
        Files.write(newFile,content);
        return newFile.toAbsolutePath().toString();
    }
    public FileSystemResource findInFileSystem(String location) {
        try {
            return new FileSystemResource(Paths.get(location));
        } catch (Exception e) {
            // Handle access or file not found problems.
            throw new RuntimeException();
        }
    }
}
