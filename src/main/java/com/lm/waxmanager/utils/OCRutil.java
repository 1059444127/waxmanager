package com.lm.waxmanager.utils;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 文字识别工具类
 */
public class OCRutil {

    /**
     * 图片文字识别(数字)
     * @param file 图片文件
     * @return
     */
    public String getOCResult(File file) {
        Tesseract instance = new Tesseract();
        String result = null;
        try {
            // 对图片进行处理
            // 黑白化
            BufferedImage image = ImageHelper.convertImageToGrayscale(ImageIO.read(file));
            // 锐化
            BufferedImage binary = ImageHelper.convertImageToBinary(image);
            // 放大5倍
            BufferedImage finalIamge = ImageHelper.getScaledInstance(binary, binary.getWidth() * 5, binary.getHeight() * 5);
            // 识别
            result = instance.doOCR(finalIamge);
            // 对识别后的值进行优化处理
            // 带all的是匹配正则表达式
            result = result.replaceAll("L", "1");
            result = result.replaceAll(" ", "");
            result = result.replaceAll("[A-Za-z]+", "");
            result = result.replace(".", "");
            result = result.replaceAll("°", "0");
            return result;
        } catch (TesseractException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
