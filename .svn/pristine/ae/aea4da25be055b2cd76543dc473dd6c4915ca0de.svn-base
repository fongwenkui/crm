package com.java.web.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import com.java.domain.Customer;
import com.java.domain.LinkMan;
import com.java.service.LinkManService;
import com.java.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("linkManAction")
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	@Resource(name="linkManService")
	private LinkManService lms;
	private LinkMan linkMan = new LinkMan();
	private Integer currentPage;
	private Integer pageSize;

	/**
	 * 添加联系人
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		lms.save(linkMan);
		return "toList";
	}
	
	/**
	 * 删除联系人
	 * @return
	 */
	public String delete(){
		lms.deleteById(linkMan);
		return "toList";
	}
	
	/**
	 * 回显数据到修改页面
	 * @return
	 */
	public String toEdit(){
		LinkMan linkMan=lms.getLinkManById(this.linkMan.getLkm_id());
		ActionContext.getContext().put("linkMan", linkMan);
		return "edit";
	}

	/**
	 * 联系人列表
	 * 
	 * @return
	 */
	public String list() {
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		 if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
		 dc.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() +
		 "%")); }
		 if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
			 dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		 }
		 
		PageBean<LinkMan> pageBean = lms.getPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}

	public void setLms(LinkManService lms) {
		this.lms = lms;
	}

	public LinkMan getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(LinkMan linkMan) {
		this.linkMan = linkMan;
	}

	@Override
	public LinkMan getModel() {
		return linkMan;
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
