package com.JohtoLeagueApp.Utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilsBeans {

	@Bean
	public ModelMapper modelMap() {
		return new ModelMapper();
	}
}
