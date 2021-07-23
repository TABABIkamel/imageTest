package com.image.image;
import java.io.File;
import java.io.FileInputStream;

import org.apache.http.entity.ContentType;
import org.apache.poi.util.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.image.image.service.FileLocationService;




@SpringBootApplication
public class ImageApplication implements CommandLineRunner {
@Autowired
FileLocationService FileLocationService;
	public static void main(String[] args) {
		SpringApplication.run(ImageApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
