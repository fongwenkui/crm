package com.java.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.java.dao.BaseDao;
import com.java.domain.Customer;
import com.java.utils.PageBean;

public interface CustomerService extends BaseService<Customer>  {
	
	PageBean<Customer> getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	void save(Customer customer);

	Customer getById(Long cust_id);

	Long getIdByName(String param_name);

	void deleteById(Customer customer);
	
	List<Object[]>getIndustryCount();


}
