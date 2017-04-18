package com.oaec.model;
/*
 * javaBean
 */
public class Student {
	public Student() {
		super();
	}

	private String sid;
	private String sname;
	private int sage;
	private char ssex;

	public Student(String sid, String sname, int sage, char ssex, String sphone) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
		this.sphone = sphone;
	}

	private String sphone;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public char getSsex() {
		return ssex;
	}

	public void setSsex(char ssex) {
		this.ssex = ssex;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
}
