package com.ctgu.springmvc.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Found {
	private int foundId;
	private int userId;
	private String foundName;
	private String foundType;
	private Date foundDate;//Ê°µ½Ê±¼ä
	private String foundPlace;
	private String foundPhone;
	private Date reportDate;
	private String storePlace;
	private String foundInfo;
	private String foundCity;
	private int state;
	private String image;
	
	public Found() {
		super();
	}

	public int getFoundId() {
		return foundId;
	}

	public void setFoundId(int foundId) {
		this.foundId = foundId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFoundName() {
		return foundName;
	}

	public void setFoundName(String foundName) {
		this.foundName = foundName;
	}

	public String getFoundType() {
		return foundType;
	}

	public void setFoundType(String foundType) {
		this.foundType = foundType;
	}

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	public String getFoundPlace() {
		return foundPlace;
	}

	public void setFoundPlace(String foundPlace) {
		this.foundPlace = foundPlace;
	}

	public String getFoundPhone() {
		return foundPhone;
	}

	public void setFoundPhone(String foundPhone) {
		this.foundPhone = foundPhone;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getStorePlace() {
		return storePlace;
	}

	public void setStorePlace(String storePlace) {
		this.storePlace = storePlace;
	}

	public String getFoundInfo() {
		return foundInfo;
	}

	public void setFoundInfo(String foundInfo) {
		this.foundInfo = foundInfo;
	}

	public String getFoundCity() {
		return foundCity;
	}

	public void setFoundCity(String foundCity) {
		this.foundCity = foundCity;
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
		return "Found [foundId=" + foundId + ", userId=" + userId + ", foundName=" + foundName + ", foundType="
				+ foundType + ", foundDate=" + foundDate + ", foundPlace=" + foundPlace + ", foundPhone=" + foundPhone
				+ ", reportDate=" + reportDate + ", storePlace=" + storePlace + ", foundInfo=" + foundInfo
				+ ", foundCity=" + foundCity + ", state=" + state + ", image=" + image + "]";
	}

	
	
	
}
