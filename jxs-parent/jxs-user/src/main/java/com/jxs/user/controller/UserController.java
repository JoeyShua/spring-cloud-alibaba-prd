package com.jxs.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jxs.common.vo.Res;
import com.jxs.user.entity.User;
import com.jxs.user.service.user.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public Res addUser() {
		return Res.success(userService.addUser());
	}

	@GetMapping("/findUserList")
	public Res findUserList(User user) {
		return Res.success(userService.findUserList(user));
	}

	@PostMapping("/deleteUserById")
	public Res deleteUserById(Long id) {
		return Res.success(userService.deleteUserById(id));
	}

	/**
	 * @param user
	 */
	@PostMapping("/updateUser")
	public Res updateUser(@RequestBody User user) {
		return Res.success(userService.updateUser(user));
	}

}
