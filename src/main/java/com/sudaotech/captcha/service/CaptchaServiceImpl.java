package com.sudaotech.captcha.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.sudaotech.core.service.BaseServiceImpl;

public class CaptchaServiceImpl extends BaseServiceImpl implements CaptchaService {

 // 字体
    private static final String[] fontTypes = { "\u5b8b\u4f53", "\u65b0\u5b8b\u4f53", "\u9ed1\u4f53", "\u6977\u4f53", "\u96b6\u4e66" };
    // 定义验证码的字符表
    // char[] chars =
    // "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrsuvwxyz".toCharArray();
    private static final char[] chars = "0123456789".toCharArray();

    @Override
    public String createCaptchaCode() {
        int length = 4;
        char[] rands = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int rand = (int) (random.nextInt(chars.length));
            rands[i] = chars[rand];
        }
        
        return String.valueOf(rands);
    }

    @Override
    public byte[] createCaptchaImage(String captchaCode) throws IOException {
        
        int width = 70;
        int height = 20;
        
        // 创建内存图像并获得其图形上下文
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        drawBackground(g, width, height);

        // 产生随机的验证码
        char[] rands = captchaCode.toCharArray();
        
        // 绘制图像
        drawBackground(g, width, height);
        drawRandCode(g, rands);
        // shear(g, width, height, Color.white);
        // g.clipRect(0, 0, width-30, height-10);
        // 结束图像的绘制过程,完成图像
        g.dispose();

        // 将图像输出到客户端
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", bos);
        return bos.toByteArray();
    }
    
    /**
     * 画随机码
     * 
     * @param g
     * @param rands
     */
    private void drawRandCode(Graphics g, char[] rands) {
        Random random = new Random();
        for (int i = 0; i < rands.length; i++) {
            int yRandAdd = random.nextInt(8);
            int fontSize = 14;
            if (yRandAdd > 3) {
                fontSize = 14 + random.nextInt(10);
            } else {
                fontSize = 14 + random.nextInt(7);
            }
            
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(10)));
            g.setFont(new Font(fontTypes[random.nextInt(fontTypes.length)], Font.ITALIC | Font.BOLD, fontSize));
            // 在不同的高度上输出验证码的每个字符
            g.drawString("" + rands[i], i * 17 + 2, 13 + yRandAdd);
        }
    }
    
    /**
     * 画背景
     * 
     * @param g
     */
    private void drawBackground(Graphics g, int width, int height) {
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, width, height);
        // 随机产生若干个干扰点
        for (int i = 0; i < 50; i++) {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            g.setColor(new Color(red, green, blue));
            g.drawOval(x, y, 1, 0);
        }
    }

}
