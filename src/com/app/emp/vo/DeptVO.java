package com.app.emp.vo;

import java.io.Serializable;

import com.app.emp.bean.Address;

public class DeptVO implements Serializable{
	
	private static final long serialVersionUID = 6529834338908244309L;
	private int deptId;
	private String name;
	private String descri;
	private Address addr;
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
/*	@Override
	public String toString(){
		return "[{deptId:" + deptId + ", name:" + name + ", list:"
				+ descri + ",addr:"+addr.toString()+"}]";
	}*/
}
