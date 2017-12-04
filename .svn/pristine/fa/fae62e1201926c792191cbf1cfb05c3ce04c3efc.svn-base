package com.java.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.java.dao.LinkManDao;
import com.java.domain.LinkMan;
@Repository("linkManDao")
public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao{
	@Resource(name="sessionFactory")
	public void setFc(SessionFactory sf){
		super.setSessionFactory(sf);
	}
}
