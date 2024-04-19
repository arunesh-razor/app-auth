package com.atlas.auth.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.atlas.auth.configs.BaseObjects;
import com.atlas.auth.models.User;

@Component
public class ObjectConverters {
	
	@Autowired
	BaseObjects baseObjects;
	
	private Logger log = LoggerFactory.getLogger(OncePerRequestFilter.class);
	
	public com.atlas.auth.entities.User mapUserRequestObjectToDao(User userRequest) {
		com.atlas.auth.entities.User userDao = null;
		
		try {
			userDao = baseObjects.getObjectMapper().convertValue(userRequest, com.atlas.auth.entities.User.class);
		} catch (IllegalArgumentException ex) {
			log.error("Error mapping Request User to Dao Object : ",userRequest);
		}
		
		return userDao;
	}
	
	public User mapUserDaoObjectToRequest(com.atlas.auth.entities.User userDao) {
		User userRequestObj = null;
		
		try {
			userRequestObj = baseObjects.getObjectMapper().convertValue(userDao, User.class);
		} catch (IllegalArgumentException ex) {
			log.error("Error mapping Request User to Dao Object : ",userDao);
		}
		
		return userRequestObj;
	}

}
