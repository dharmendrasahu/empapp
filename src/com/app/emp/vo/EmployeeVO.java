package com.app.emp.vo;

import java.util.Date;

public class EmployeeVO {
	private int empId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String deptName;
	private int deptId;
	private Date doj;
	private String grade;
	private String position;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public EmployeeVO(int empId, String firstName, String middleName,
			String lastName, String deptName, int deptId, Date doj, String grade,String position) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.deptName = deptName;
		this.deptId = deptId;
		this.doj = doj;
		this.grade = grade;
		this.position=position;
	}	
}
