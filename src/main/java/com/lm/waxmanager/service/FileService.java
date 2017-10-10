package com.lm.waxmanager.service;

import com.lm.waxmanager.utils.FileManagerUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    /**
     * 文件上传
     * @param file
     * @param updPath
     * @return
     */
    public String fileUpd(MultipartFile file, String updPath) {
        return new FileManagerUtil().upload(file, updPath);
    }
}
