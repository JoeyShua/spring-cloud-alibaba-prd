package com.jxs.user.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxs.user.entity.User;
import com.jxs.user.mapper.UserMapper;
import com.jxs.user.service.user.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 添加用户信息
	 */
	@Override
	public Object addUser() {

		User user = new User();
		user.setPassword("zhangsan");
		user.setUserName("zhangsan");
		userMapper.insert(user);
		return null;
	}

	@Override
	public Object findUserList(User user) {
		
		LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>().lambda();
		/*
		 * if(user.getUserName() != "") { wrapper.eq(User::getUserName,
		 * user.getUserName()); }
		 */
		int aa = 1/0;
		
        return userMapper.selectList(wrapper);
	}

	@Override
	public Object deleteUserById(Long id) {
		userMapper.deleteById(id);
		return null;
	}

	@Override
	public Object updateUser(User user) {
		userMapper.updateById(user);
		return null;
	}

}
