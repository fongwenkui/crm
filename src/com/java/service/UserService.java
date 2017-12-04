package com.java.service;

import com.java.domain.User;

public interface UserService extends BaseService<User> {
		User getUserByCode(User u);
		
		void save(User u);

		void saveUser(User u);
}
