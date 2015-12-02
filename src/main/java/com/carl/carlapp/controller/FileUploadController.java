package com.carl.carlapp.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("cfile") MultipartFile file) throws IOException {
		System.out.println("....test");
		
		float imageQuality = 0.3f;//文件压缩比例

        if (!file.isEmpty()) {
        	System.out.println(file.getContentType());
        	
        	UUID uuid = UUID.randomUUID();
            InputStream ips = file.getInputStream();
            OutputStream ops = new FileOutputStream(new File("e:\\data\\"+uuid.toString()+".jpg"));
            
            //读文件
            BufferedImage bufferedImage = ImageIO.read(ips);
            
            //Get image writers
            Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByFormatName("jpg");
            
            if(imageWriters.hasNext()){
            	ImageWriter imageWriter = imageWriters.next();
            	ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(ops);
            	imageWriter.setOutput(imageOutputStream);
            	
            	ImageWriteParam writeParam = imageWriter.getDefaultWriteParam();
            	writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            	writeParam.setCompressionQuality(imageQuality);
            	
            	//Created image
            	imageWriter.write(null, new IIOImage(bufferedImage, null, null), writeParam);
            	// close all streams
            	imageOutputStream.close();
            	imageWriter.dispose();
            }
            
         // close all streams
    		ips.close();
    		ops.close();
            
            // store the bytes somewhere
           return "redirect:/";
       } else {
           return "redirect:/";
       }
    }
}
