package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UpFileService {
    private final ServletContext servletContext;

    public UpFileService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleUpFile(MultipartFile file, String targetFolder) {

        if (file.isEmpty())
            return "";

        String rootPath = servletContext.getRealPath("/resources/images");
        String finalFileName = "";
        File dir = new File(rootPath + File.separator + targetFolder);
        try {
            if (!dir.exists())
                dir.mkdirs();

            byte[] bytes = file.getBytes();

            finalFileName = System.currentTimeMillis() + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalFileName);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalFileName;
    }

}
