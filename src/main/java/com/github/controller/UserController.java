package com.github.controller;

import com.github.bean.PageBean;
import com.github.mapper.UserMapper;
import com.github.model.User;
import com.github.repository.UserRepository;
import com.github.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class UserController {

	@Resource private UserMapper userMapper;
	@Resource private UserRepository userRepository;

	@Resource
	private UserService userService;

	@GetMapping({"", "/", "index"})
	public String index() {

//		User user = new User();
//		user.setName("iMiracle");
//		user.setClassName("className");
//		userRepository.save(user);
//
//		List<User> userList = userRepository.findAll();
//		System.err.println(userList);
//
//		userList = userMapper.getAll();
//		System.err.println(userList);
//
//		userList = userMapper.getAllXml();
//		System.err.println(userList);

		return "index";
	}

	@RequestMapping("user/pagination")
	@ResponseBody
	public PageBean<User> pagination(HttpServletRequest request) {
		PageBean<User> pageBean = PageBean.buildFromRequest(request);
		userService.pagination(pageBean);
		return pageBean;
	}

}
