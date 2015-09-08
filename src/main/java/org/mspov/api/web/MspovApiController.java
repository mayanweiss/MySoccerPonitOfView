package org.mspov.api.web;
//package com.mkyong.helloworld.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.mspov.api.service.MspovApiService;;
//import com.mkyong.helloworld.service.HelloWorldService;

@Controller
public class MspovApiController {

	private final Logger logger = LoggerFactory.getLogger(MspovApiController.class);
	private final MspovApiService mspovApiService;

	@Autowired
	public MspovApiController(MspovApiService mspovApiService) {
		this.mspovApiService = mspovApiService;
	}

	@RequestMapping(value = "/mspov", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", mspovApiService.getTitle(""));
		model.put("msg", mspovApiService.getDesc());
		
		return "index";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		model.addObject("title", mspovApiService.getTitle(name));
		model.addObject("msg", mspovApiService.getDesc());
		
		return model;

	}

}
