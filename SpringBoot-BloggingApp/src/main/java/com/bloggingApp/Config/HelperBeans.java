package com.bloggingApp.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelperBeans {

	@Bean
	public ModelMapper modelMapping() {
		return new ModelMapper();
	}
}
