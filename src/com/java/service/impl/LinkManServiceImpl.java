package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.LinkManDao;
import com.java.domain.Customer;
import com.java.domain.LinkMan;
import com.java.service.LinkManService;
import com.java.utils.PageBean;
@Service("linkManService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class LinkManServiceImpl extends BaseServiceImpl<LinkMan> implements LinkManService {
	@Resource(name="linkManDao")
	private LinkManDao lmd;

	@Override
	public void save(LinkMan linkMan) {
		lmd.saveOrUpdate(linkMan);
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
		super.setBaseDao(lmd);
	}

	@Override
	public PageBean<LinkMan> getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount=lmd.getTotalCount(dc);
		PageBean<LinkMan> pageBean=new PageBean<>(currentPage, pageSize, totalCount);
		List<LinkMan> list=lmd.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 删除联系人(通过id)
	 */
	@Override
	public void deleteById(LinkMan linkMan) {
		lmd.delete(linkMan.getLkm_id());
	}

	/**
	 * 获得LinkMan对象根据id
	 */
	@Override
	public LinkMan getLinkManById(Long lkm_id) {
		return lmd.getById(lkm_id);
	}

}
