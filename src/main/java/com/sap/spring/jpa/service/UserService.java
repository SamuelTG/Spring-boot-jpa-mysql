/**
 * 
 */
package com.sap.spring.jpa.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sap.spring.jpa.User;
import com.sap.spring.jpa.repo.UserRepo;

/**
 * @author I303450
 *
 */
@RestController
public class UserService {
	@Autowired
	UserRepo userRepo;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/echo")
	public String greeting(
			@RequestParam(value = "speak", defaultValue = "echo") String name) {
		return new String(String.format(template, name));
	}

	@RequestMapping("/addUser")
	public Long addUser(User user) {

		if (user != null) {
			userRepo.save(user);
			return user.getId();
		}
		return -1L;
	}

	@RequestMapping("/getUser")
	public User getUser(@RequestParam(value = "id", defaultValue = "1") Long id) {

		User user = userRepo.findOne(id);
		return user;
	}

	@RequestMapping
	public String data() {

		String info = " ";

		userRepo.save(new User("Ben", "Den"));
		userRepo.save(new User("John", "Smith"));

		for (User user : userRepo.findAll()) {
			info += " " + user;
		}

		return info;
	}
}
