package com.app.emp.vo;

import java.util.Date;

import com.app.emp.bean.Address;

public class EmploymentHistoryVO {
	private int id;
	private String comName;
	private Address comAddr;
	private String position;
	private Date fromDt;
	private Date toDt;
	private int empID;
	private String changeReason;
	
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public Address getComAddr() {
		return comAddr;
	}
	public void setComAddr(Address comAddr) {
		this.comAddr = comAddr;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getFromDt() {
		return fromDt;
	}
	public void setFromDt(Date fromDt) {
		this.fromDt = fromDt;
	}
	public Date getToDt() {
		return toDt;
	}
	public void setToDt(Date toDt) {
		this.toDt = toDt;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public EmploymentHistoryVO(int id, String comName, Address comAddr,
			String position, Date fromDt, Date toDt, int empID,String changeReason) {
		super();
		this.id = id;
		this.comName = comName;
		this.comAddr = comAddr;
		this.position = position;
		this.fromDt = fromDt;
		this.toDt = toDt;
		this.empID = empID;
		this.changeReason=changeReason;
	}
	
	
}
