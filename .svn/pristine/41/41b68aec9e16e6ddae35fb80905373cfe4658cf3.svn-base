package com.java.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//从session域中查找有没有user
		Object userObj = ActionContext.getContext().getSession().get("user");
		if (userObj==null) {
			return "toLogin";
		}else{
			//放行
			return invocation.invoke();
		}
	}

}
