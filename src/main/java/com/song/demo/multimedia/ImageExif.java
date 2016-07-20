/*
 * Copyright (c) 2016, zhangsong <songm.cn>.
 *
 */
package com.song.demo.multimedia;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * 首先介绍一下什么是EXIF，EXIF是 Exchangeable Image File的缩写，
 * 这是一种专门为数码相机照片设定的格式。这种格式可以用来记录数字
 * 照片的属性信息，例如相机的品牌及型号、相片的拍摄时间、拍摄时所
 * 设置的光圈大小、快门速度、ISO等等信息。除此之外它还能够记录拍
 * 摄数据，以及照片格式化方式，这样就可以输出到兼容EXIF格式的外设
 * 上，例如照片打印机等。
 * <p>
 *
 * 目前最常见的支持EXIF信息的图片格式是JPG，很多的图像工具都可以直
 * 接显示图片的EXIF信息，包括现在的一些著名的相册网站也提供页面用于
 * 显示照片的EXIF信息。本文主要介绍Java语言如何读取图像的EXIF信息，
 * 包括如何根据EXIF信息对图像进行调整以适合用户浏览。
 * <p>
 * 
 * 将图片的所有的EXIF信息全部打印出来。
 * <p>
 *
 * @author zhangsong
 * @since 1.0, 2016-7-20
 * @version 1.0
 * 
 */
public class ImageExif {

    public static void main(String[] args) throws JpegProcessingException,
            IOException {
        String path = "";
        File jFile = new File(path);
        Metadata metadata = JpegMetadataReader.readMetadata(jFile);
        for (Directory dir : metadata.getDirectories()) {
            for (Tag tag : dir.getTags()) {
                System.out.println(tag);
            }
        }
    }
}
