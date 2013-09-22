package com.app.emp.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{
	private static final long serialVersionUID = 708266588714204471L;
	
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String country;
	private String zip;
	
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/*@Override
	public String toString(){
		return "[{addr1:" + addr1 + ", addr2:" + addr2 + ", city:"
		+ city + "state:" + state + ", country:" + country +",zip :" + zip + "}]";
	}*/
}
