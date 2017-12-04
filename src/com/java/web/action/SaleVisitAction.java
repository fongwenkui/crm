package com.java.web.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import com.java.domain.Customer;
import com.java.domain.SaleVisit;
import com.java.domain.User;
import com.java.service.SaleVIsitService;
import com.java.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("saleVisitAction")
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	@Resource(name="saleVisitService")
	private SaleVIsitService svs;
	
	private SaleVisit saleVisit=new SaleVisit();
	private Integer currentPage;
	private Integer pageSize;
	
	public String add() throws Exception{
		User user= (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(user);
		svs.save(saleVisit);
		return "toList";
	}
	
	public String list() {
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		if (saleVisit.getCustomer()!=null&&StringUtils.isNotBlank(saleVisit.getCustomer().getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%" + saleVisit.getCustomer().getCust_name() + "%"));
		}
		PageBean<SaleVisit> pageBean = svs.getPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}
	
	
	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}


	public SaleVisit getSaleVisit() {
		return saleVisit;
	}


	public void setSaleVisit(SaleVisit saleVisit) {
		this.saleVisit = saleVisit;
	}


	public void setSvs(SaleVIsitService svs) {
		this.svs = svs;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
