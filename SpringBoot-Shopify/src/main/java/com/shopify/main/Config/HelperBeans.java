package com.shopify.main.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelperBeans {

	@Bean
	public ModelMapper model_conversion() {
		return new ModelMapper();	
		}
}
