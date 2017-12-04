package com.java.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.dao.UserDao;
import com.java.domain.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	@Resource(name="sessionFactory")
	public void setFc(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	@Override
	public User getUserByCode(final String code) {
		//hql
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql="from User where user_code=:code";
				Query query = session.createQuery(hql);
//				query.setString(0, code);
//				query.setParameter("code",code);
				query.setString("code", code);
				return (User) query.uniqueResult();
			}
		});
		
		//criteria
		/*DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", code));
		List<User> users = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if (users!=null&&users.size()>0) {
			return users.get(0);
		}
		return null;*/
	}

}
