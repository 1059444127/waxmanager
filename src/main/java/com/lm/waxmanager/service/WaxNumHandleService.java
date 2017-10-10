package com.lm.waxmanager.service;

import com.lm.waxmanager.domain.WaxInTmp;
import com.lm.waxmanager.utils.OCRutil;
import com.lm.waxmanager.utils.SubImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 蜡块入库病理号处理
 */
@Service
public class WaxNumHandleService {


    @Value("${web.out-path}")
    private String outPath;

    @Autowired
    private WaxInTmpService waxInTmpService;

    /**
     * 病理号识别处理
     * @param filePath
     * @return
     */
    public void waxNumOCRHandle(String filePath) {
        // 获取图片文件
        File file = new File(filePath);
        try {
            // 获取bufferdImage对象
            BufferedImage image = ImageIO.read(file);
            // 切割图片，得到切割后的图片url列表
            List<String> imgurls = new SubImageUtil().subImage(image, 1, 12, outPath);
            // 分别进行识别并得到结果列表
            for (int i = 0; i < imgurls.size(); i++) {
                WaxInTmp waxInTmp = new WaxInTmp();
                // 设置waxin
                waxInTmp.setWaxinid(i);
                waxInTmp.setImgurl(imgurls.get(i));
                waxInTmp.setPathnum(new OCRutil().getOCResult(new File(outPath + imgurls.get(i))));
                // 添加到list
//                waxIns.add(waxIn);
                // 添加到数据库临时表
                this.waxInTmpService.addWaxIn(waxInTmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
