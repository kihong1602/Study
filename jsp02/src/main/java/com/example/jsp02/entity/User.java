package com.example.jsp02.entity;

public class User {
	
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
	
	public User(Builder userBuilder) {
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
	
	@Override
	public String toString() {
		return "[ " + no + " | " + id + " | " + password + " | " + name + " | " + email + " | "
				+ tel + " | " + postcode + " | " + address
				+ " | " + addressDetail + " | " + regDate + " ]";
	}
	
	public int getNo() {
		return no;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPostcode() {
		return postcode;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getAddressDetail() {
		return addressDetail;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTel() {
		return tel;
	}
	
	public String getProfile() {
		return profile;
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
		
		public User build() {
			return new User(this);
		}
	}
}


