package com.sintanbabo.meeting.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScans(value = {
		@ComponentScan("com.sintanbabo.meeting.controller"),
		@ComponentScan("com.sintanbabo.meeting.filter")
		})
public class WebConfig extends WebMvcConfigurerAdapter {

}