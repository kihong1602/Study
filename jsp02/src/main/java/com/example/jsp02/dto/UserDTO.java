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
	
	
	public UserDTO(Builder userBuilder) {
		this.no = userBuilder.no;
		this.id = userBuilder.id;
		this.password = userBuilder.password;
		this.name = userBuilder.name;
		this.postcode = userBuilder.postcode;
		this.address = userBuilder.address;
		this.addressDetail = userBuilder.addressDetail;
		this.regDate = userBuilder.regDate;
		this.email = userBuilder.email;
		this.tel = userBuilder.tel;
		this.profile = userBuilder.profile;
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
	
	public static class Builder {
		
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
		
		public Builder() {
		}
		
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		
		public Builder no(int no) {
			this.no = no;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder postcode(int postcode) {
			this.postcode = postcode;
			return this;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		public Builder addressDetail(String addressDetail) {
			this.addressDetail = addressDetail;
			return this;
		}
		
		public Builder regDate(String regDate) {
			this.regDate = regDate;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder tel(String tel) {
			this.tel = tel;
			return this;
		}
		
		public Builder profile(String profile) {
			this.profile = profile;
			return this;
		}
		
		public UserDTO build() {
			return new UserDTO(this);
		}
	}
}
