package com.app.emp.vo;

import java.util.Date;

import javax.persistence.Column;

import com.app.emp.bean.Address;
import com.app.emp.bean.Employee;

public class EmployeeDetailVO {
	private int employeeId;
	private Date DOB;
	private String pan;
	private String phoneNo;
	private String sex;
	private String fatherName;
	private String motherName;
	private Address presAddr;
	private Address permaAddr;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Address getPresAddr() {
		return presAddr;
	}
	public void setPresAddr(Address presAddr) {
		this.presAddr = presAddr;
	}
	public Address getPermaAddr() {
		return permaAddr;
	}
	public void setPermaAddr(Address permaAddr) {
		this.permaAddr = permaAddr;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public EmployeeDetailVO(int employeeId, Date dOB,
			String pan, String phoneNo, String sex, Address presAddr,
			Address permaAddr,String fatherName,String motherName) {
		super();
		this.employeeId = employeeId;
		this.DOB = dOB;
		this.pan = pan;
		this.phoneNo = phoneNo;
		this.sex = sex;
		this.presAddr = presAddr;
		this.permaAddr = permaAddr;
		this.fatherName=fatherName;
		this.motherName=motherName;
	}
	
	
}
