package com.java.service.impl;

import java.io.Serializable;
import java.util.List;

import com.java.dao.BaseDao;
import com.java.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDao<T> baseDao;
	
	 public BaseDao<T> getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	public void save(T entity) {
	        baseDao.save(entity);
	    }
	    public void delete(T entity) {
	        baseDao.delete(entity);
	    }
	    public void update(T entity) {
	        baseDao.update(entity);
	    }
	    public T findById(Serializable id) {
	        return baseDao.getById(id);
	    }

}
