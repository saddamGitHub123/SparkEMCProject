package com.backend.emcspark.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;




/**
 * 
 * @author saddam
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@EnableWebMvc

public class PageController {
	
	 private static final Logger logger = LoggerFactory.getLogger(PageController.class);
		
	  
	
//	@Autowired
//	public UserDAO userDAO;

	//This is for home page 
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		logger.info("This is the PageController ");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "      Welcome to Spring And Hibernate World for Spark Project ");
		return mv;
	}
	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	   mav.addObject("user", new User());
	    return mav;
	  }*/
	/*
	 @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) {
	  userDao.register(user);
	  return new ModelAndView("welcome", "firstname", user.getFirstname());
	  }*/



}
