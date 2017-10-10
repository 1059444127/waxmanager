package com.lm.waxmanager.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 文件管理工具类
 */
public class FileManagerUtil {

    /**
     * 上传文件
     * @param file 需要上传的文件
     * @param updPath 上传路径
     * @return
     */
    public String upload(MultipartFile file, String updPath) {
        String fileName = file.getOriginalFilename();
        // 创建目标文件
        File dest = new File(updPath + fileName);
        if (!dest.getParentFile().exists()) {
            // 不存在，则创建
            dest.getParentFile().mkdirs();
        }
        // 存在，拷贝至新文件
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(dest));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
            return updPath + fileName;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
