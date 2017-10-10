package com.lm.waxmanager.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * 图片剪切工具类
 */
public class SubImageUtil {

    /**
     * 根据列数和每列个数进行切割
     * @param image 图片
     * @param col 列数
     * @param num 每列个数
     */
    public List<String> subImage(BufferedImage image, int col, int num, String outPath) {
        // 得到图片高度
        int iHeigth = image.getHeight();
        // 图片宽度
        int iWidth = image.getWidth();
        // 需要切割的图片高度
        int sHeight = (int) (iHeigth * 1.0 / num);
        // 需要切割的图片宽度
        int sWidth = (int) (iWidth * 1.0 / col);
        // 切割
        BufferedImage bufferedImage = null;
        List list = new LinkedList();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < num; j++) {
                // 切割图片
                bufferedImage = image.getSubimage(i * sWidth + 221, j * sHeight, sWidth - 221, sHeight);
                // 命名
                String filename = UUID.randomUUID().toString() + ".jpg";
                try {
                    // 输出到文件
                    // 图片地址增加时间路径
                    String timePath = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
                    File file = new File(outPath + timePath + filename);
                    if (!file.getParentFile().exists()) {
                        // 不存在,则创建多级目录
                        file.getParentFile().mkdirs();
                    }
                    ImageIO.write(bufferedImage, "JPEG", file);

                    // 添加到list
                    list.add(timePath + filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

}
