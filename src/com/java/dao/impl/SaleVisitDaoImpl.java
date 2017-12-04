package com.java.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.java.dao.SaleVisitDao;
import com.java.domain.SaleVisit;
@Repository("saleVisitDao")
public class SaleVisitDaoImpl extends BaseDaoImpl<SaleVisit> implements SaleVisitDao {
	@Resource(name="sessionFactory")
	public void setFc(SessionFactory sf){
		super.setSessionFactory(sf);
	}
}
