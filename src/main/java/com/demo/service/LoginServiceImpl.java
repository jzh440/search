
package com.demo.service;

import com.demo.model.User;

public interface LoginServiceImpl extends BaseServiceImpl<User> {

	public User login(User user);
}
