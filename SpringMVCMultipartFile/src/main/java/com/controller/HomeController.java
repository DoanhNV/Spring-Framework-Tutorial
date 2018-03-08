package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String loadHomePage() {
		return "upload";
	}
	
	@RequestMapping(value = "/upload")
	public String uploadFile(@RequestParam("file") MultipartFile  multipartFile) throws IOException {
		File sourceFile = new File(multipartFile.getOriginalFilename());
		FileInputStream source = new FileInputStream(sourceFile);
		FileUtils.copyInputStreamToFile(source, new File("D:/" + sourceFile.getName()));
		return "/";
	}
}
