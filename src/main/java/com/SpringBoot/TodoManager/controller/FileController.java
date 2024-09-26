package com.SpringBoot.TodoManager.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger= LoggerFactory.getLogger(FileController.class);


    @PostMapping("/single")
    public String uploadsingle(@RequestParam("image")MultipartFile file){
        logger.info("Name {}",file.getName());
        logger.info("ContentType {}",file.getContentType());
        logger.info("OriginalName {} ",file.getOriginalFilename());
        logger.info("FileSize {} ",file.getSize());
        return "File testing";
    }
    @PostMapping("/multiple")
    public String uploadMultiple(@RequestParam("files") MultipartFile[] files){

        Arrays.stream(files).forEach(file->{
            logger.info("OriginalFileName : {} ",file.getOriginalFilename());
            logger.info("FileType: {} ",file.getContentType());

        });
        return "Handling Multiple Files";
    }

    @GetMapping("/serve-image")
    public void serveImage(HttpServletResponse response)  {
       try {
           InputStream inputStream = new FileInputStream("Images/client.jpg");
           response.setContentType(MediaType.IMAGE_JPEG_VALUE);
           StreamUtils.copy(inputStream,response.getOutputStream());
       }
       catch (Exception e){
           e.printStackTrace();
       }

    }

}
