package com.ctgu.ssm.utils;
/**  
* @Title: FileUtil.java  
*
* @Package com.ctgu.collegeservice.utils  
*
* @Description: 文件处理基本工具
*
* @author Fantasy  
*
* @date 2018年12月20日  
*
* @version V1.0  
*/

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;


public class UploadUtil {
	// 获取操作系统文件分隔符
	private static String seperator = System.getProperty("file.separator");
	// 时间格式化
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random random = new Random();

	/**
	 * 获取文件上传根路径
	 * @return 用户上传文件根路径
	 */
	public static String getUploadBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/collegeservice/upload/";
		} else {
			basePath = "/usr/tomcat/apache-tomcat-8.5.33/webapps/collegeupload";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	
	/**
	 * 获取 根路径和path拼接 后的路径
	 * @param path 附加目录
	 * @return 生成文件保存路径
	 */
	public static String getFilePath(String path) {
		String filePath = getUploadBasePath() + path;
		filePath = filePath.replace("/", seperator);
		return filePath;
	}
	
	/**
	 * 格式化路径
	 * @param path 需要格式化的路径
	 * @return 格式化(文件分隔符匹配)后路径
	 */
	public static String pathFormat(String path) {
		return path.replace("/", seperator);
	}
	
	/**
	 * 获取随机文件名(当前年月日时分秒+五位随机数)
	 * @return 获取随机文件名
	 */
	public static String getRandomFileName() {
		//随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）
		//获取随机数
		int rannum = (int)(random.nextDouble() * (99999 - 10000 + 1)) + 10000;
		String nowTimeStr = sdf.format(new Date());
		return nowTimeStr+rannum;
	}
	
	/**
	 * 
	 * @param path 删除路径下文件
	 */
	public static void deleteFile(String path) {
		File file = new File(getUploadBasePath()+path);
		if(file.exists()) {
			if(file.isDirectory()) {
				File files[] = file.listFiles();
				for(int i = 0;i < file.length();i++) {
					files[i].delete();
				}
				file.delete();
			}
		}
	}
	
	/**
	 * 获取文件后缀名
	 * @param file 目标文件
	 * @return 文件后缀
	 */
	public static String getFileExtension(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		return fileName.substring(fileName.lastIndexOf("."));
	}
}
