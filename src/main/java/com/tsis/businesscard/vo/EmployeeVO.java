package com.tsis.businesscard.vo;

public class EmployeeVO {
	private int seq;
	private String name;
	private String team;
	private String address;
	private String tel;
	private String phone;
	private String fax;
	private String email;
	private String url;
	private String position;
	
	public EmployeeVO() {
		super();
	}
	public EmployeeVO(int seq, String name, String team, String address, String tel, String phone, String fax,
			String email, String url, String position) {
		super();
		this.seq = seq;
		this.name = name;
		this.team = team;
		this.address = address;
		this.tel = tel;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.url = url;
		this.position = position;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "EmployeeVO [seq=" + seq + ", name=" + name + ", team=" + team + ", address=" + address + ", tel=" + tel
				+ ", phone=" + phone + ", fax=" + fax + ", email=" + email + ", url=" + url + ", position=" + position
				+ "]";
	}
	
}
