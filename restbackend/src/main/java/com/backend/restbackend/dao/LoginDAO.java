package com.backend.restbackend.dao;

import java.util.List;

import com.backend.restbackend.user.dto.DistanceClass;
import com.backend.restbackend.user.dto.User;
import com.backend.restbackend.user.model.DistanceClassModel;

/**
 * 
 */


/**
 * @author Sk Saddam Hosan
 *
 */
public interface LoginDAO {
	
	/**
	 * login validation 
	 * **/
	
	User checkLogin(User loginuser);
	
	List<DistanceClass> validDistance(DistanceClassModel distanceClassModel);
}
