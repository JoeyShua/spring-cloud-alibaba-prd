package com.jxs.user.service.user;

import com.jxs.user.entity.User;

public interface UserService {

	/**
	 * 添加用户
	 */
	Object addUser();

	/**
	 * @param user 查詢用戶列表
	 * @return
	 */
	Object findUserList(User user);

	/**
	 * @param id
	 *  根据id 删除用户
	 */
	Object deleteUserById(Long id);

	/**
	 * @param user
	 * 更新用户
	 */
	Object updateUser(User user);

}
