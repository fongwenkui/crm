package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.CustomerDao;
import com.java.domain.Customer;
import com.java.service.CustomerService;
import com.java.utils.PageBean;
@Service("customerService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {
	@Resource(name="customerDao")
	private CustomerDao cd;
	
	public void setCd(CustomerDao cd) {
		this.cd = cd;
		super.setBaseDao(cd);
	}

	/**
	 *	列表显示(分页处理)
	 */
	@Override
	public PageBean<Customer> getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount=cd.getTotalCount(dc);
		PageBean<Customer> pageBean=new PageBean<>(currentPage, pageSize, totalCount);
		List<Customer> list=cd.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 保存客户
	 */
	@Override
	public void save(Customer customer) {
		cd.saveOrUpdate(customer);
	}

	/**
	 * 通过id获得客户对象
	 */
	@Override
	public Customer getById(Long cust_id) {
		return cd.getById(cust_id);
	}

	/**
	 * 联系人ajax同步根据名字获取id值
	 */
	@Override
	public Long getIdByName(String param_name) {
		return cd.getIdByName(param_name);
	}

	/**
	 * 删除联系人
	 */
	@Override
	public void deleteById(Customer customer) {
		cd.delete(customer.getCust_id());
	}
	
	public List<Object[]> getIndustryCount(){
		List<Object[]> list = cd.getIndustryCount();
		return list;
	};

}
