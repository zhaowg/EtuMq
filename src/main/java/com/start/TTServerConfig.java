package com.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:server_params.properties")
public class TTServerConfig {
	@Autowired
	Environment env;

	@Bean
	public TTServerStart serverStart() {
		TTServerStart start = new TTServerStart();
		start.setStopPort(Integer.parseInt(env.getProperty("server.stopport")));
		start.setStopKey(env.getProperty("server.stopkey"));
		start.setStartPort(Integer.parseInt(env.getProperty("server.startport")));
		start.setWarPath(env.getProperty("server.warPath"));
		start.setGzip(Boolean.valueOf(env.getProperty("server.isGzip")));
		start.setMaxThreads(Integer.parseInt(env.getProperty("server.maxThreads")));
		
		return start;
	}
}