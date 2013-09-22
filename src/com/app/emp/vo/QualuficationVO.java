package com.app.emp.vo;


public class QualuficationVO {
	private int id;
	private String degree;
	private String board;
	private String fromYr;
	private String toYr;
	private int duration;
	private String grade;
	private int empID;
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
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public QualuficationVO(int id, String degree, String board, String fromYr,
			String toYr, int duration, String grade, int empID) {
		super();
		this.id = id;
		this.degree = degree;
		this.board = board;
		this.fromYr = fromYr;
		this.toYr = toYr;
		this.duration = duration;
		this.grade = grade;
		this.empID = empID;
	}
	
}
