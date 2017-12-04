package com.java.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.dao.UserDao;
import com.java.domain.User;
import com.java.service.BaseService;
import com.java.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	@Resource(name="userDao")
	private UserDao ud;
	
	@Test
	public void test(){
		User byId = ud.getById(2l);
		User u = ud.getUserByCode("a");
		System.out.println(u.getUser_code());
	}
//	public UserDao getUd() {
//		return ud
//	}
//	public void setUd(UserDao ud) {
//		this.ud = ud
//	}
//	public UserService getUs() {
//		return us;
//	}
//	public void setUs(UserService us) {
//		this.us = us;
//	}
	
	
}
