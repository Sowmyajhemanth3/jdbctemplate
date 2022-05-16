package com.src.bean;

public class Student {

	private String stdid;
	private String stdpwd;
	private String stdname;
	private String State;
	private int stdage;
	private String stdaddress;
	private long stdmob;
	
	public String getStdid() {
		return stdid;
	}
	public void setStdid(String stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getStdaddress() {
		return stdaddress;
	}
	public void setStdaddress(String stdaddress) {
		this.stdaddress = stdaddress;
	}
	public int getStdage() {
		return stdage;
	}
	public void setStdage(int stdage) {
		this.stdage = stdage;
	}
	public long getStdmob() {
		return stdmob;
	}
	public void setStdmob(long mob){
		this.stdmob = stdmob;
	}
	public String getStdpwd() {
		return stdpwd;
	}
	public void setStdpwd(String stdpwd) {
		this.stdpwd = stdpwd;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String stdid, String stdpwd, String stdname, int stdage, String stdaddress, long stdmob) {
		super();
		this.stdid = stdid;
		this.stdpwd = stdpwd;
		this.stdname = stdname;
		this.stdage = stdage;
		this.stdaddress = stdaddress;
		
		this.stdmob = stdmob;
		
	}
	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", stdname=" + stdname + ", stdaddress=" + stdaddress + ", stdage=" + stdage
				+ ", stdmob=" + stdmob + ", stdpwd=" + stdpwd + "]";
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
}
