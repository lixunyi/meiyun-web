package com.meiyun.web.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 属性文件加载
 * @author Administrator
 *
 */
public enum PropertiesUtil {
	
	INSTANCE;
	
	private PropertiesUtil() {}
	
	/**
	 * 读取配置文件信息
	 * @param filename
	 * @return
	 */
	public Map<Object, Object> load(String properties) {
		try {
			Map<Object,Object> map = new HashMap<Object, Object>();
			InputStream inStream = new FileInputStream(new File(PropertiesUtil.class
					.getResource("/").getPath() + properties));
			Properties prop = new Properties();
			prop.load(inStream);
			for (Object object : prop.keySet()) {
				map.put(object, prop.get(object));
			}
			inStream.close();
			return map;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
