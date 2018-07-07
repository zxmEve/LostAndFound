package com.ctgu.springmvc.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Lost {
	private int lostId;
	private int userId;
	private String lostName;
	private String lostType;
	private Date lostDate;//丢失时间
	private String lostPlace;
	private String lostPhone;
	private Date reportDate;//报失时间
	private String lostInfo;
	private String lostCity;
	private int state;
	private String image;
	
	public int getLostId() {
		return lostId;
	}
	public void setLostId(int lostId) {
		this.lostId = lostId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLostName() {
		return lostName;
	}
	public void setLostName(String lostName) {
		this.lostName = lostName;
	}
	public String getLostType() {
		return lostType;
	}
	public void setLostType(String lostType) {
		this.lostType = lostType;
	}
	public Date getLostDate() {
		return lostDate;
	}
	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}
	public String getLostPlace() {
		return lostPlace;
	}
	public void setLostPlace(String lostPlace) {
		this.lostPlace = lostPlace;
	}
	public String getLostPhone() {
		return lostPhone;
	}
	public void setLostPhone(String lostPhone) {
		this.lostPhone = lostPhone;
	}
	
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getLostInfo() {
		return lostInfo;
	}
	public void setLostInfo(String lostInfo) {
		this.lostInfo = lostInfo;
	}
	public String getLostCity() {
		return lostCity;
	}
	public void setLostCity(String lostCity) {
		this.lostCity = lostCity;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Lost [lostId=" + lostId + ", userId=" + userId + ", lostName=" + lostName + ", lostType=" + lostType
				+ ", lostDate=" + lostDate + ", lostPlace=" + lostPlace + ", lostPhone=" + lostPhone + ", reportDate="
				+ reportDate + ", lostInfo=" + lostInfo + ", lostCity=" + lostCity + ", state=" + state + ", image="
				+ image + "]";
	}
}
