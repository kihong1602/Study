package com.example.jsp02.dto;

public class UserDTO {
	
	private int no;
	private String id;
	private String password;
	private String name;
	private int postcode;
	private String address;
	private String addressDetail;
	private String regDate;
	private String email;
	private String tel;
	private String profile;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(int no, String id, String password, String name, int postcode, String address,
			String addressDetail, String regDate, String email, String tel, String profile) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.postcode = postcode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.regDate = regDate;
		this.email = email;
		this.tel = tel;
		this.profile = profile;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPostcode() {
		return postcode;
	}
	
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddressDetail() {
		return addressDetail;
	}
	
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
}
