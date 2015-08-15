package com.meiyun.commons.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class Uploader {

	public static String upload(MultipartFile file, HttpServletRequest request)
			throws IOException {
		String filename = null;
		if (!file.isEmpty()) {
			System.out.println(file.getContentType() + ":" + file.getName());
			System.out.println(file.getOriginalFilename());

			String path = request.getSession().getServletContext()
					.getRealPath("/images")
					+ File.separator;
			filename = file.getOriginalFilename();
			filename = UUID.randomUUID().toString()
					.concat(filename.substring(filename.lastIndexOf('.')));
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					path.concat(filename)));
		}

		return filename;
	}
	
}
