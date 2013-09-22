package com.app.emp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="QUALIFICATION")
public class Qualification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="DEGREE",nullable=false,length=40)
	private String degree;
	@Column(name="BOARD",nullable=false,length=60)
	private String board;
	@Column(name="FROM_Y",nullable=false,length=10)
	private String fromYr;
	@Column(name="TO_Y",nullable=false,length=10)
	private String toYr;
	@Column(name="DURATION",nullable=false)
	private int duration;
	@Column(name="GRADE",nullable=false,length=10)
	private String grade;
	
	@ManyToOne
    @JoinColumn(name="EMP_ID")
    private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getFromYr() {
		return fromYr;
	}

	public void setFromYr(String fromYr) {
		this.fromYr = fromYr;
	}

	public String getToYr() {
		return toYr;
	}

	public void setToYr(String toYr) {
		this.toYr = toYr;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
