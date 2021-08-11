package com.skillstorm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="devices")
public class Device {
	
	@Id //primary key
	@Column(name="phoneNumber")
	String phoneNumber;
	
	@Column(name="userID")
	@NotBlank
	int userID;
	
	@Column(name="dataPlanID")
	@NotBlank
	int dataPlanID;
	
	@Column(name="deviceName")
	@NotBlank
	String deviceName;
	
	@Column(name="deviceDescription")
	@NotBlank
	String deviceDescription;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userID")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dataPlanID")
	private Plan plan;

	public Device() {
		super();
	}

	public Device(String phoneNumber, @NotBlank int userID, @NotBlank int dataPlanID, @NotBlank String deviceName,
			@NotBlank String deviceDescription, User user, Plan plan) {
		super();
		this.phoneNumber = phoneNumber;
		this.userID = userID;
		this.dataPlanID = dataPlanID;
		this.deviceName = deviceName;
		this.deviceDescription = deviceDescription;
		this.user = user;
		this.plan = plan;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getDataPlanID() {
		return dataPlanID;
	}

	public void setDataPlanID(int dataPlanID) {
		this.dataPlanID = dataPlanID;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceDescription() {
		return deviceDescription;
	}

	public void setDeviceDescription(String deviceDescription) {
		this.deviceDescription = deviceDescription;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Device [phoneNumber=" + phoneNumber + ", userID=" + userID + ", dataPlanID=" + dataPlanID
				+ ", deviceName=" + deviceName + ", deviceDescription=" + deviceDescription + "]";
	}
	
	
}
