package com.efub.kurlyclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class FileHandler{
    public String parseFileInfo(
            MultipartFile multipartFile
    ) throws Exception{
        String file_path;

        if(multipartFile.isEmpty()){
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());
        String file_name = current_date + multipartFile.getOriginalFilename();

        String absolutePath = new File("").getAbsolutePath()+"/";
        String path = "uploads";
        File file = new File(absolutePath+path);
        if(!file.exists()){
            file.mkdirs();
        }

        String contentType = multipartFile.getContentType();
        String originalFileExtension;

        if(ObjectUtils.isEmpty(contentType)){
            return null;
        }else{
            if(contentType.contains("image/jpeg")){
                originalFileExtension = ".jpg";
            }
            else if(contentType.contains("image/png")){
                originalFileExtension = ".png";
            }
            else{
                return null;
            }
        }

        file_path = path+"/"+file_name+originalFileExtension;
        file = new File(absolutePath+file_path);
        multipartFile.transferTo(file);

        return file_path;
    }
}
