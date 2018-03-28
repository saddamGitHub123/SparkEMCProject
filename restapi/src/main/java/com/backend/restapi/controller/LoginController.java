/**
 * 
 */
package com.backend.restapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.backend.restbackend.user.model.LoginResponse;
import com.backend.restbackend.user.dto.User;
import com.backend.restbackend.dao.LoginDAO;


/**
 * @author Sk Saddam Hosan
 *
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@EnableWebMvc
@RequestMapping("login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	public LoginDAO loginDAO;
	
	@RequestMapping(value = "/user/shop", method = RequestMethod.POST)
	public @ResponseBody LoginResponse loginUser(@RequestBody User loginuser) {

		logger.info("User & Shopkeeper Entered loginUser() in LoginController  - Post username and password for USER");
		LoginResponse loginResponse = new LoginResponse() ;
		
		try {
			// Create main class Object			
			User userDetails = loginDAO.checkLogin(loginuser);
			if (userDetails == null) {
				loginResponse.setStatus_code("400");
				loginResponse.setStatus_message("User Name and Password not found");
				logger.error("User name and password not found");
				
				return loginResponse;
			}
			else {

			    loginResponse.setStatus_code("200");
				loginResponse.setStatus_message("Successfully");
				logger.debug("User name and password  found");
				//logger.D("User name and password  found");
				loginResponse.setData(userDetails);
				return loginResponse;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public @ResponseBody LoginResponse awsTest(@RequestBody User loginuser) {

		logger.info("aws Testing");
		LoginResponse loginResponse = new LoginResponse() ;
		
		try {
			// Create main class Object			
			//User userDetails = loginDAO.checkLogin(loginuser);
			String username = loginuser.getUser_Name() ;
			String password = loginuser.getUser_Password() ;
			//if (loginuser.getUser_Name() == "syn" && loginuser.getUser_Password() == "1234") {
			if (username.equals("syn") && password.equals("1234")) {
				
				   loginResponse.setStatus_code("200");
					loginResponse.setStatus_message("Successfully");
					logger.debug("User name and password  found");
					//logger.D("User name and password  found");
					loginuser.setName("Synixia");
					loginuser.setEmail("synixia@synixia.com");
					loginuser.setContact("7204414827");
					loginuser.setShop_ID("Shop_1");
					loginuser.setUser_ID("User_1");
					loginuser.setUser_Name("syn");
					loginuser.setUser_Password("1234");
					loginResponse.setData(loginuser);
					
				return loginResponse;
			}
			else {
				
				loginResponse.setStatus_code("400");
				loginResponse.setStatus_message("User Name and Password not found");
				logger.error("User name and password not found");
			   
				return loginResponse;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
