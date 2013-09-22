package com.app.emp.bean;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="EMPLOYEE_DETAIL")
public class EmployeeDetail {
	
	@Id
    @Column(name="employee_id", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="employee"))
    private int employeeId;
	
	@OneToOne
    @PrimaryKeyJoinColumn
    private Employee employee;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOB",nullable=false)
	private Date DOB;

	@Column(name="PAN",nullable=true,length=10)
	private String pan;
	
	
	@Column(name="PHONE_NO",nullable=true,length=10)
	private String phoneNo;
	
	@Column(name="SEX",nullable=false,length=2)
	private String sex;
	
	@Column(name="FATHER_NAME",nullable=false,length=50)
	private String fatherName;
	
	@Column(name="MOTHER_NAME",nullable=false,length=50)
	private String motherName;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="addr1",column=@Column(name="PRES_ADDR1")),
			@AttributeOverride(name="addr2",column=@Column(name="PRES_ADDR2")),
			@AttributeOverride(name="city",column=@Column(name="PRES_CITY")),
			@AttributeOverride(name="state",column=@Column(name="PRES_STATE")),
			@AttributeOverride(name="country",column=@Column(name="PRES_COUNTRY")),
			@AttributeOverride(name="zip",column=@Column(name="PRES_ZIP"))})
	private Address presAddr;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="addr1",column=@Column(name="PERMA_ADDR1")),
			@AttributeOverride(name="addr2",column=@Column(name="PERMA_ADDR2")),
			@AttributeOverride(name="city",column=@Column(name="PERMA_CITY")),
			@AttributeOverride(name="state",column=@Column(name="PERMA_STATE")),
			@AttributeOverride(name="country",column=@Column(name="PERMA_COUNTRY")),
			@AttributeOverride(name="zip",column=@Column(name="PERMA_ZIP"))})
	private Address permaAddr;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
}
