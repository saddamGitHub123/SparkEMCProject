package com.backend.restbackend.user.model;

import java.util.List;

import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.user.dto.DistanceClass;
import com.backend.restbackend.user.dto.User;

/**
 * @author Sk Saddam Hosan
 *
 */
public class LoginResponse extends SuccResponse{
	
	public User Data;
	
	public List<DistanceClass> allDistanceValue;
	public LoginResponse() {}

	/**
	 * @return the data
	 */
	/*public User getData() {
		return Data;
	}*/

	/**
	 * @param data
	 */
	public LoginResponse(User data) {
		super();
		Data = data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(User data) {
		Data = data;
	}
	

	/**
	 * @param allDistanceValue
	 */
	public LoginResponse(List<DistanceClass> allDistanceValue) {
		super();
		this.allDistanceValue = allDistanceValue;
	}


	/**
	 * @return the allDistanceValue
	 */
	public List<DistanceClass> getAllDistanceValue() {
		return allDistanceValue;
	}

	/**
	 * @param allDistanceValue the allDistanceValue to set
	 */
	public void setAllDistanceValue(List<DistanceClass> allDistanceValue) {
		this.allDistanceValue = allDistanceValue;
	}

	/**
	 * @return the data
	 */
	public User getData() {
		return Data;
	}


	
	
	

}
