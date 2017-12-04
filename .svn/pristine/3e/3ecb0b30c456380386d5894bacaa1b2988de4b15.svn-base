package com.java.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.java.domain.BaseDict;
import com.java.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.spi.orbutil.fsm.ActionBase;

import net.sf.json.JSONArray;

@Controller("BaseDictAction")
public class BaseDictAction extends ActionSupport {
	
	private String dict_type_code;
	
	@Resource(name="baseDictService")
	private BaseDictService bds;

	@Override
	public String execute() throws Exception {
		List<BaseDict> list=bds.getListByTypeCode(dict_type_code);
		String json = JSONArray.fromObject(list).toString();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return null;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}
	
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	public void setBds(BaseDictService bds) {
		this.bds = bds;
	}
}
