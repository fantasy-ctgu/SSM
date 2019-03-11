package com.ctgu.ssm.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * @Title: RespUtil.java
 *
 * @Package com.ctgu.collegeservice.utils
 *
 * @Description: HttpServletResponse相关工具
 *
 * @author Fantasy
 *
 * @date 2018年12月28日
 *
 * @version V1.0
 */
public class RespUtil {
	public static boolean sendStrToResp(HttpServletResponse response, String content) {
		OutputStream oStream;
		try {
			oStream = response.getOutputStream();
			response.setHeader("content-type", "text/html;charset=UTF-8");
			oStream.write(content.getBytes("UTF-8"));
			oStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean sendFileToResp(HttpServletResponse response, String path, String filename) {
		InputStream is;
		try {
			is = new BufferedInputStream(new FileInputStream(new File(path)));
			response.addHeader("Content-Disposition", "attachment;filename=" + filename);
			response.setContentType("multipart/form-data");
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			int len = 0;
			while ((len = is.read()) != -1) {
				out.write(len);
				out.flush();
			}
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
