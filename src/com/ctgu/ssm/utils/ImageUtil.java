package com.ctgu.ssm.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

/**
 * @Title: ImageUtil.java
 *
 * @Package com.ctgu.collegeservice.utils
 *
 * @Description: 图片处理工具
 *
 * @author Fantasy
 *
 * @date 2018年12月22日
 *
 * @version V1.0
 */
public class ImageUtil {
	public static String fileDir = "img/";

	private static void makeDirPath(String targetAddr) {
		File dirPath = new File(targetAddr);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 保存图片
	 * @param multipartFile 目标图片
	 * @return 图片的相对路径
	 */
	public static String generateNormalImg(MultipartFile multipartFile) {
		String fileName = UploadUtil.getRandomFileName();
		String extension = UploadUtil.getFileExtension(multipartFile);
		String imgPath = UploadUtil.getFilePath(fileDir);
		makeDirPath(imgPath);
		String imgFile = imgPath + fileName + extension;
		File dest = new File(imgFile);
		try {
			Thumbnails.of(multipartFile.getInputStream()).size(200, 200).outputQuality(0.5f).toFile(dest);
		} catch (IOException e) {
			System.out.println("创建缩略图失败");
			e.printStackTrace();
			return null;
		}
		return UploadUtil.pathFormat(fileDir + "/" + fileName + extension);
	}
}
