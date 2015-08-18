package com.meiyun.core.upload;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.fastupload.FastUploadParser;
import net.sourceforge.fastupload.MultiPart;

public class Uploader {

	public void upload(HttpServletRequest request) {
		
		try {
			FastUploadParser fastUploadParser = new FastUploadParser(request);
			List<MultiPart> list = fastUploadParser.parseList();
			for (MultiPart e : list) {
				if (e.isFile()) {
					System.out.format("input field name: %s, file name:%s%n", e.getFieldName(), e.getFileName());
					e.toFile( "/file/") ; //write data to a file where you want to place
				} else {
					System.out.format("input field name: %s, value:%s%n", e.getFieldName(), e.getString());
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
