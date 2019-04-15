package com.jj.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jj.service.UserService;
import com.jj.vo.User;

@Controller
public class HibernateJavaConfigConfigExampleController {
	
	@Autowired
	private UserService userService;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/example1", method = RequestMethod.GET)
	public String example1(Model model) {

		User user = userService.findUserByNo(1);
		
		if (user == null) {
			userService.createDummyUser();			
		}
		
		log.info(user);
		
		return "example1";
	}
	
	@RequestMapping(value = "/example2", method = RequestMethod.GET)
	public String example2(Model model) {
		
		List<User> users = new ArrayList<>();
		
		users.add(new User("dummy1", "password", "dummy1@gmail.com", "Dummy1"));
		users.add(new User("dummy2", "password", "dummy2@gmail.com", "Dummy2"));
		users.add(new User("dummy3", "password", "dummy3@gmail.com", "Dummy3"));
		users.add(new User("dummy4", "password", "dummy4@gmail.com", "Dummy4"));
		users.add(new User("dummy5", "password", "dummy5@gmail.com", "Dummy5"));
		
		users = userService.insertUserList(users, "example2");
		model.addAttribute("users", users);
		
		return "example2";
	}
	
	@RequestMapping(value = "/example3", method = RequestMethod.GET)
	public String example3(Model model) {
		
		List<User> users = new ArrayList<>();
		
		users.add(new User("dummy1", "password", "dummy1@gmail.com", "Dummy1"));
		users.add(new User("dummy2", "password", "dummy2@gmail.com", "Dummy2"));
		users.add(new User("dummy3", "password", "dummy3@gmail.com", "Dummy3"));
		users.add(new User("dummy4", "password", "dummy4@gmail.com", "Dummy4"));
		users.add(new User("dummy5", "password", "dummy5@gmail.com", "Dummy5"));
		
		users = userService.insertUserList(users, "example3");
		model.addAttribute("users", users);
		
		return "example3";
	}
}

