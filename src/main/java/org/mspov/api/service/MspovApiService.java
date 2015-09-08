package org.mspov.api.service;
//package com.mkyong.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MspovApiService {
///public class HelloWorldService {

	private static final Logger logger = LoggerFactory.getLogger(MspovApiService.class);

	public String getDesc() {

		logger.debug("getDesc() is executed!");

		return "MySoccerPointOfView";

	}

	public String getTitle(String name) {

		logger.debug("getTitle() is executed! $name : {}", name);

		if(StringUtils.isEmpty(name)){
			return "Hello Soccer World";
		}else{
			return "Hello champ " + name;
		}
		
	}

}
