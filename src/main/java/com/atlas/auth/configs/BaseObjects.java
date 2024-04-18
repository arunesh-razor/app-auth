package com.atlas.auth.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BaseObjects {
	
	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper mapper =  new ObjectMapper();
		
		// Important: this must be declared so mapper doesn't throw 
	    // an exception for all properties which it can't map.
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    
	    return mapper;
	}

}
