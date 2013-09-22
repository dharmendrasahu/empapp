package com.app.emp.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMP_ID")
	private int empId;
	
	@Column(name="FIRST_NAME",nullable=false,length=50)
	private String firstName;
	
	@Column(name="MIDDLE_NAME",nullable=true,length=50)
	private String middleName;
	
	@Column(name="LAST_NAME",nullable=true,length=50)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOJ",nullable=false)
	private Date doj;
	
	@Column(name="GRADE",nullable=false,length=40)
	private String grade;
	
	@Column(name="POSITION",nullable=false,length=50)
	private String position;
	
	@OneToMany(mappedBy="employee")
	private Set<Qualification> qualifi;

	@OneToMany(mappedBy="employee")
	private Set<EmploymentHistory> empHsty;
	
	@ManyToOne
    @JoinColumn(name="DEPT_ID")
    private Department department;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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
	
	public Set<Qualification> getQualifi() {
		return qualifi;
	}

	public void setQualifi(Set<Qualification> qualifi) {
		this.qualifi = qualifi;
	}

	public Set<EmploymentHistory> getEmpHsty() {
		return empHsty;
	}

	public void setEmpHsty(Set<EmploymentHistory> empHsty) {
		this.empHsty = empHsty;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
