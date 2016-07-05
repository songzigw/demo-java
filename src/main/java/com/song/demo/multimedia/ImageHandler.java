/*
 * Copyright (c) 2016, zhangsong <songm.cn>.
 *
 */
package com.song.demo.multimedia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 图片处理
 *
 * @author zhangsong
 * @since 1.0, 2016-7-4
 * @version 1.0
 * 
 */
public class ImageHandler {

    /**
     * 图片编码
     * @param imgPath
     * @return
     * @throws IOException
     */
    public static String encode64(String imgPath) throws IOException {
        InputStream input = new FileInputStream(imgPath);
        byte[] data = new byte[input.available()];
        input.read(data);
        input.close();

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * 图片解码
     * 
     * @param imgStr
     * @param imgPath
     * @return
     * @throws IOException
     */
    public static boolean decode64(String imgStr, String imgPath)
            throws IOException {
        if (imgStr == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(imgStr);
        for (int i = 0; i < bytes.length; i++) {
            // 调整异常数据
            if (bytes[i] < 0) {
                bytes[i] += 256;
            }
        }
        OutputStream out = new FileOutputStream(imgPath);
        out.write(bytes);
        out.flush();
        out.close();

        return true;
    }
}
