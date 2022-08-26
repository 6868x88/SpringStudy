package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basic() {
		log.info("basic..................");
	}

	
	@GetMapping("/basicOnlyGet")
	public void basicGet2(){
		log.info("basic get only get...........");
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload........");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		return "ex01";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06........");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("ȫ�浿");
		
		return dto;
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page) {
		log.info("dto: "+dto);
		log.info("page: "+page);
		return "sample/ex04";
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file ->{
			log.info("-----------------------------------");
			log.info("name: "+file.getOriginalFilename());
			log.info("size: "+file.getSize());
		});
	}
}
