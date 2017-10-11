package com.lm.waxmanager.utils;

import com.lm.waxmanager.domain.RGB;
import net.sourceforge.tess4j.util.ImageHelper;

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
 * 图片处理
 */
public class ImageHandle {
    public static void main(String[] args) {
        System.out.println("hello image");
        foo();
    }

    public static void foo() {
        File file = new File("D:\\WorkStation\\WaxMan-upd\\aaa.jpg");
        try {
            BufferedImage image = ImageIO.read(file);
            int height = image.getHeight();
            int width = image.getWidth();
            // 灰度
            image = ImageHelper.convertImageToGrayscale(image);
            ImageIO.write(image, "JPEG", new File("D:\\WorkStation\\WaxMan-upd\\test-black.jpg"));
            // 锐化
            image = ImageHelper.convertImageToBinary(image);
            ImageIO.write(image, "JPEG", new File("D:\\WorkStation\\WaxMan-upd\\test-binary.jpg"));

            List<RGB> list = new LinkedList<>();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int r = 0, g = 0, b = 0;
                    int pixel = image.getRGB(j, i);

                    RGB rgb = new RGB();

                    r = (pixel & 0xff0000) >> 16;
                    g = (pixel & 0xff00) >> 8;
                    b = (pixel & 0xff);

                    rgb.setX(i);
                    rgb.setY(j);
                    rgb.setRgb(r + g + b);
                    list.add(rgb);

                }
            }
            int up = findUp(list);
            int down = findDown(list);
            int left = findLeft(list);
            subImage(image, left, up, width - left, down - up);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findUp(List<RGB> rgbs) {
        int count = 0;
        for (RGB rgb: rgbs) {
            if (rgb.getRgb() == 0) {
                count++;
                if (count >= 30) {
                    System.out.println(rgb.getX());
                    return rgb.getX();
                }
            } else {
                count = 0;
            }
        }
        return 0;
    }

    public static int findDown(List<RGB> rgbs) {
        int count = 0;
        for (RGB rgb: rgbs) {
            if (rgb.getRgb() == 765) {
                count++;
                if (count > 500) {
                    System.out.println(rgb.getX());
                    return rgb.getX();
                }
            } else {
                count = 0;
            }
        }
        return 0;
    }

    public static int findLeft(List<RGB> rgbs) {
        int count = 0;
        for (RGB rgb: rgbs) {
            if (rgb.getRgb() == 0) {
                count++;
                if (count == 1) {
                    System.out.println(rgb.getX());
                    return rgb.getY();
                }
            } else {
                count = 0;
            }
        }
        return 0;
    }

    public static void subImage(BufferedImage image, int x, int y, int sWidth, int sHeight) {
        // 切割
        BufferedImage bufferedImage = null;
        // 切割图片
        bufferedImage = image.getSubimage(x, y, sWidth, sHeight);
        try {
            // 输出到文件
            File file = new File("D:\\WorkStation\\WaxMan-upd\\test-cut.jpg");
            ImageIO.write(bufferedImage, "JPEG", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
