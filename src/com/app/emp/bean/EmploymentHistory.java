package com.app.emp.bean;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPLOYMENT_HISTORY")
public class EmploymentHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="COM_NAME",nullable=false,length=60)
	private String comName;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="addr1",column=@Column(name="COM_ADDR1")),
			@AttributeOverride(name="addr2",column=@Column(name="COM_ADDR2")),
			@AttributeOverride(name="city",column=@Column(name="COM_CITY")),
			@AttributeOverride(name="state",column=@Column(name="COM_STATE")),
			@AttributeOverride(name="country",column=@Column(name="COM_COUNTRY")),
			@AttributeOverride(name="zip",column=@Column(name="COM_ZIP"))})
	private Address comAddr;
	
	@Column(name="POSITION",nullable=false,length=20)
	private String position;
	
	@Column(name="EMP_ID",nullable=false,length=10)
	private int empId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FROM_DATE",nullable=false)
	private Date fromDt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TO_DATE",nullable=false)
	private Date toDt;
	
	@Column(name="CHANGE_REASON",nullable=false,length=40)
	private String changeReason;
	
	@ManyToOne
    @JoinColumn(name="EMP_ID",insertable=false,updatable=false)
    private Employee employee;

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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
}
