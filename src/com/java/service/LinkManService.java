package com.java.service;

import org.hibernate.criterion.DetachedCriteria;

import com.java.domain.Customer;
import com.java.domain.LinkMan;
import com.java.utils.PageBean;

public interface LinkManService extends BaseService<LinkMan> {

	void save(LinkMan linkMan);

	PageBean<LinkMan> getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	void deleteById(LinkMan linkMan);

	LinkMan getLinkManById(Long lkm_id);

}
