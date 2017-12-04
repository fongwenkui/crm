package com.java.utils;

import java.util.List;

public class PageBean<T> {
	
	public PageBean(Integer currentPage,Integer pageSize,Integer totalCount){
		this.currentPage=currentPage;
		this.pageSize=pageSize;
		this.totalCount=totalCount;
		if (this.currentPage==null) {
			this.currentPage=1;
		}
		if (this.pageSize==null) {
			this.pageSize=3;
		}
		this.totalPage=(int) Math.ceil(this.totalCount*1.0/this.pageSize);
		//超过范围
		if (this.currentPage<1) {
			this.currentPage=1;
		}
		if (this.currentPage>this.totalPage) {
			this.currentPage=this.totalPage;
		}
	}
	
	private Integer currentPage;
	private Integer pageSize;
	private Integer totalPage;
	private Integer totalCount;
	private List<T> list;
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", list=" + list + "]";
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
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getStart() {
		return (this.currentPage-1)*pageSize;
	}
}
