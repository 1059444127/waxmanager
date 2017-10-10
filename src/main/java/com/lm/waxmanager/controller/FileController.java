package com.lm.waxmanager.controller;

import com.lm.waxmanager.service.FileService;
import com.lm.waxmanager.service.WaxNumHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件管理
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private WaxNumHandleService waxNumHandleService;

    @Value("${web.upd-path}")
    private String updPath;

    /**
     * 文件上传并识别
     * @param file
     * @return
     */
    @RequestMapping(value = "/uao", method = RequestMethod.POST)
    public String updAndOCR(MultipartFile file) {
        // 文件上传后目录
        String filePath = this.fileService.fileUpd(file, updPath);
        // 对该文件进行识别处理
        this.waxNumHandleService.waxNumOCRHandle(filePath);
        return "redirect:/uao";
    }
}
