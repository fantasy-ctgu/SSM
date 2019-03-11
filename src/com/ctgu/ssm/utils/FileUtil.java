package com.ctgu.ssm.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Title: ImageUtil.java
 *
 * @Package com.ctgu.collegeservice.utils
 *
 * @Description: 文件处理工具
 *
 * @author Fantasy
 *
 * @date 2018年12月22日
 *
 * @version V1.0
 */
public class FileUtil {
	public static String fileDir = "file/";

	/**
	 * 创建文件夹(递归创建)
	 * @param targetAddr 
	 */
	private static void makeDirPath(String targetAddr) {
		File dirPath = new File(targetAddr);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}
	
	/**
	 * 保存文件
	 * @param multipartFile 目标文件
	 * @return 文件保存后的相对地址
	 */
	public static String generateFile(MultipartFile multipartFile) {
		String fileName = UploadUtil.getRandomFileName();
		String extension = UploadUtil.getFileExtension(multipartFile);
		String filePath = UploadUtil.getFilePath(fileDir);
		makeDirPath(filePath);
		String fileFile = filePath + fileName + extension;
		File dest = new File(fileFile);
		try {
			multipartFile.transferTo(dest);
		} catch (IOException e) {
			System.out.println("保存文件失败");
			return null;
		}
		return UploadUtil.pathFormat(fileDir + "/" + fileName + extension);
	}
}
