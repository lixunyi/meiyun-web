package com.meiyun.commons.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @class 生成缩略图工具类
 * @see http://code.google.com/p/thumbnailator/
 * @description  Thumbnailator是一个为Java界面更流畅的缩略图生成库。
 * @excption 需要注意的是，对于CMYK模式的图像，由于JDK的Bug，目前还不能够处理，会出异常
 * @author sion.qi
 * @date 2015-02-01
 */
public class Thumbnailator {
	
	/**
	 * @throws IOException 
	 * @method 指定大小进行缩放
	 * 若图片横比200小，高比300小，不变   <br>
	 * 若图片横比200小，高比300大，高缩小到300，图片比例不变   <br>
	 * 若图片横比200大，高比300小，横缩小到200，图片比例不变   <br>
	 * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300 <br>
	 */ 
	public void auto(URL urls, int width, int height, File file) throws IOException {
		Thumbnails.of(urls).size(width, height).toFile(file);
	}
	
	/**
	 * 按比例进行缩放
	 * @throws IOException 
	 */
	public void auto2() throws IOException {
		Thumbnails.of("images/a380_1280x1024.jpg")   
        .scale(0.25f)  
        .toFile("c:/a380_25%.jpg");  
	}
	
	/**
	 * 不按照比例，指定大小进行缩放
	 * @throws IOException
	 */
	public void auto3() throws IOException {
		//keepAspectRatio(false) 默认是按照比例缩放的  
		Thumbnails.of("images/a380_1280x1024.jpg")   
		        .size(200, 200)   
		        .keepAspectRatio(false)   
		        .toFile("c:/a380_200x200.jpg"); 
	}
	
	/**
	 * @method 旋转
	 * @throws IOException
	 */
	public void rotate() throws IOException {
		//rotate(角度),正数：顺时针 负数：逆时针  
		Thumbnails.of("images/a380_1280x1024.jpg")   
		        .size(1280, 1024)  
		        .rotate(90)   
		        .toFile("c:/a380_rotate+90.jpg");
	}
	
	/**
	 * 水印
	 * @throws IOException
	 */
	public void watermark() throws IOException {
		//watermark(位置，水印图，透明度)  
		Thumbnails.of("images/a380_1280x1024.jpg")   
		        .size(1280, 1024)  
		        .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("images/watermark.png")), 0.5f)   
		        .outputQuality(0.8f)   
		        .toFile("c:/a380_watermark_bottom_right.jpg");  
		  
		Thumbnails.of("images/a380_1280x1024.jpg")   
		        .size(1280, 1024)  
		        .watermark(Positions.CENTER, ImageIO.read(new File("images/watermark.png")), 0.5f)   
		        .outputQuality(0.8f)   
		        .toFile("c:/a380_watermark_center.jpg");  
	}
	
	/**
	 * 裁剪
	 * @throws IOException 
	 */
	public void auto4() throws IOException {
		//sourceRegion()  
		  
		//图片中心400*400的区域  
		Thumbnails.of("images/a380_1280x1024.jpg")  
		        .sourceRegion(Positions.CENTER, 400,400)  
		        .size(200, 200)  
		        .keepAspectRatio(false)   
		        .toFile("c:/a380_region_center.jpg");  
		  
		//图片右下400*400的区域  
		Thumbnails.of("images/a380_1280x1024.jpg")  
		        .sourceRegion(Positions.BOTTOM_RIGHT, 400,400)  
		        .size(200, 200)  
		        .keepAspectRatio(false)   
		        .toFile("c:/a380_region_bootom_right.jpg");  
		  
		//指定坐标  
		Thumbnails.of("images/a380_1280x1024.jpg")  
		        .sourceRegion(600, 500, 400, 400)  
		        .size(200, 200)  
		        .keepAspectRatio(false)   
		        .toFile("c:/a380_region_coord.jpg");  
	}
	
	/**
	 * 转化图像格式
	 * @throws IOException
	 */
	public void format() throws IOException {
		//outputFormat(图像格式)  
		Thumbnails.of("images/a380_1280x1024.jpg")   
		        .size(1280, 1024)  
		        .outputFormat("png")   
		        .toFile("c:/a380_1280x1024.png");   
		  
		Thumbnails.of("images/a380_1280x1024.jpg")   
		        .size(1280, 1024)  
		        .outputFormat("gif")   
		        .toFile("c:/a380_1280x1024.gif");
	}
	
	/**
	 * 输出到OutputStream
	 * @throws IOException 
	 */
	public void stream() throws IOException {
		//toOutputStream(流对象)  
		OutputStream os = new FileOutputStream("c:/a380_1280x1024_OutputStream.png");  
		Thumbnails.of("images/a380_1280x1024.jpg")   
		        .size(1280, 1024)  
		        .toOutputStream(os);  
	}
	
	/**
	 * 输出到BufferedImage
	 * @throws IOException
	 */
	public void bufferedImage() throws IOException {
		//asBufferedImage() 返回BufferedImage  
		BufferedImage thumbnail = Thumbnails.of("images/a380_1280x1024.jpg")   
		        .size(1280, 1024)  
		        .asBufferedImage();  
		ImageIO.write(thumbnail, "jpg", new File("c:/a380_1280x1024_BufferedImage.jpg"));  
	}

}
