package com.ctgu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
* @Title: hello.java  
*
* @Package com.ctgu.proname.controller  
*
* @Description: TODO
*
* @author Fantasy  
*
* @date 2018年11月30日  
*
* @version V1.0  
*/

@Controller
public class Hello{
	@RequestMapping("/hello")
	public String getPath() {
		return "hello";
	}
	
}
