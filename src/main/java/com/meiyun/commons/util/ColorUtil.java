package com.meiyun.commons.util;

import java.util.Arrays;
import java.util.List;

/**
 * 主题颜色搭配：活泼、快乐、有趣 
 * @url http://tool.c7sky.com/webcolor/#character_16
 * 活泼、快乐、有趣相对前一种印象，色彩选择更加广泛，最重要的变化是将纯白色用低饱和有彩色或者灰色取代。
 * @author Administrator
 *
 */
public class ColorUtil {
	
	/**
	 * 定义一组活泼、快乐、有趣的主题色
	 */
	private final static String[] colors = {
		"#CC9999",
		"#FFFF99",
		"#666699",
		"#FF9900",
		"#0099CC",
		"#CCCC99",
		"#CC3399",
		"#99CC00",
		"#FF6666",
		"#FFFF00",
		"#3399CC",
		"#CC6600",
		"#999999",
		"#CCCC33",
		"#FF9933",
		"#FFFFCC",
		"#009933",
		"#CCCCCC",
		"#FF6600",
		"#FFFF66",
		"#009966",
		"#CC6633",
		"#FFCC99",
		"#CC0066",
		"#009999",
		"#FFCC33"
	};
	
	/**
	 * 获取所有的颜色值
	 * @return
	 */
	public static List<String> getAllColors() {
		return Arrays.asList(colors);
	}
	
	/**
	 * 随机取色
	 * @return
	 */
	public static String getRandomColor() {
		int index = (int)(Math.random() * colors.length);
		return getAllColors().get(index);
	}

}
