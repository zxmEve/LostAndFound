package com.ctgu.springmvc.entity;

import org.springframework.stereotype.Component;

@Component
public class Page {
	private int totalPage;//总页数
	private int currentPage;//当前页
	private int totalRecord;//总计记录数
	
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalRecord) {
		if(totalRecord%5==0) {
			totalPage = totalRecord/5;
		}else {
			totalPage = totalRecord/5+1;
		}
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	@Override
	public String toString() {
		return "Page [totalPage=" + totalPage + ", currentPage=" + currentPage + ", totalRecord=" + totalRecord
				+ ", pageSize=" + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentPage;
		result = prime * result + totalPage;
		result = prime * result + totalRecord;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (currentPage != other.currentPage)
			return false;
		if (totalPage != other.totalPage)
			return false;
		if (totalRecord != other.totalRecord)
			return false;
		return true;
	}
} 
