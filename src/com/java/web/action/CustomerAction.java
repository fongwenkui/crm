package com.java.web.action;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import com.java.domain.Customer;
import com.java.service.CustomerService;
import com.java.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("customerAction")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	// 上传的文件会自动封装到File对象
	// 在后台提供一个与前台input type=file组件 name相同的属性
	private File photo;
	// 在提交键名后加上固定后缀FileName,文件名称会自动封装到属性中
	private String photoFileName;
	// 在提交键名后加上固定后缀ContentType,文件MIME类型会自动封装到属性中
	private String photoContentType;

	private String param_name;
	
	private Customer customer = new Customer();

	@Resource(name="customerService")
	private CustomerService cs;

	private Integer currentPage;
	
	private Integer pageSize;
	

	public String list() {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		PageBean<Customer> pageBean = cs.getPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}
	
	public String delete(){
		System.out.println(customer);
		cs.deleteById(customer);
		return "toList";
	}
	
	public String industryCount(){
		List<Object[]> list = cs.getIndustryCount();
		ActionContext.getContext().put("industryCount", list);
		System.out.println(list.get(0).toString());
		return "industryCount";
	}

	public String add() {
		if(photo!=null){
			System.out.println(photo);
			System.out.println("文件名称:"+photoFileName);
			System.out.println("文件类型:"+photoContentType);
			//将上传文件保存到指定位置
			photo.renameTo(new File("C:/Users/fong/Desktop/a.jpg"));
			}
		cs.save(customer);
		return "toList";
	}
	
	public String getIdByName() throws IOException{
		System.out.println(param_name);
		Long cust_id=cs.getIdByName(param_name);
		System.out.println(cust_id);
		String json="{\"cust_id\":"+cust_id+"}";
		System.out.println(json);
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	public String toEdit() throws Exception {
		Customer c = cs.getById(customer.getCust_id());
		ActionContext.getContext().put("customer", c);
		return "edit";
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getParam_name() {
		return param_name;
	}

	public void setParam_name(String param_name) {
		this.param_name = param_name;
	}
	

}
