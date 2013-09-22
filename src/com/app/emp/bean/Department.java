package com.app.emp.bean;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
public class Department {
	@Id
	@Column(name="DEPT_ID")
	private int deptId;
	
	@Column(name="NAME",nullable=false,length=40)
	private String name;
	
	@Column(name="DESCRIPTION",nullable=false,length=100)
	private String descri;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="addr1",column=@Column(name="ADDR1")),
			@AttributeOverride(name="addr2",column=@Column(name="ADDR2")),
			@AttributeOverride(name="city",column=@Column(name="CITY")),
			@AttributeOverride(name="state",column=@Column(name="STATE")),
			@AttributeOverride(name="country",column=@Column(name="COUNTRY")),
			@AttributeOverride(name="zip",column=@Column(name="ZIP"))})
	private Address addr;
	
	@OneToMany(mappedBy="department")
	private Set<Employee> emp;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescri() {
		return descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public Set<Employee> getEmp() {
		return emp;
	}
	public void setEmp(Set<Employee> emp) {
		this.emp = emp;
	}
	
}
