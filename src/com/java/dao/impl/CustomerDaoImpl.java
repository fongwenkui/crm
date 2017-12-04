package com.java.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.java.dao.CustomerDao;
import com.java.domain.Customer;
@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{
	@Resource(name="sessionFactory")
	public void setFc(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	@Override
	public Long getIdByName(final String param_name) {
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException {
				String hql="select cust_id from Customer where cust_name=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, param_name);
				Long id = (Long) query.uniqueResult();
				return id;
			}
		});
	}

	@Override
	public List<Object[]> getIndustryCount() {
		return getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {

			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				String sql="select dict_item_name,count(*) total from cst_customer c,base_dict bd where c.cust_industry=bd.dict_id group BY bd.dict_id";
				SQLQuery query = session.createSQLQuery(sql);
				List<Object[]> list=query.list();
				return list;
			}
		});
	}

}
