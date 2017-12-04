package com.java.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.UserDao;
import com.java.domain.User;
import com.java.service.UserService;


@Service("userService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	private UserDao ud;
	@Resource(name="userDao")
	public void setUd(UserDao ud) {
		this.ud = ud;
		super.setBaseDao(ud);
	}


	@Override
	public User getUserByCode(User u) {
		User existsU = ud.getUserByCode(u.getUser_code());
		if (existsU==null) {
			throw new RuntimeException("用户名不存在");
		}
		if (!existsU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误");
		}
		return existsU;
	}

	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void save(User u) {
		ud.save(u);
	}

	/**
	 * 注册
	 */
	@Override
	public void saveUser(User u) {
		System.out.println(u);
		User user = ud.getUserByCode(u.getUser_code());
		if (user!=null) {
			throw new RuntimeException("用户名已存在!");
		}
		ud.save(u);
	}

}
