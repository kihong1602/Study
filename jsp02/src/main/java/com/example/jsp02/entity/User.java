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
	
	public User(UserBuilder userBuilder) {
		this.no = userBuilder.no;
		this.id = userBuilder.id;
		this.password = userBuilder.password;
		this.name = userBuilder.name;
		this.postcode = userBuilder.postcode;
		this.address = userBuilder.address;
		this.addressDetail = userBuilder.addressDetail;
		this.regDate = userBuilder.regDate;
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
	
	public static class UserBuilder {
		
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
		
		public UserBuilder(String id) {
			
			this.id = id;
			
		}
		
		public UserBuilder no(int no) {
			this.no = no;
			return this;
		}
		
		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public UserBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public UserBuilder postcode(int postcode) {
			this.postcode = postcode;
			return this;
		}
		
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public UserBuilder addressDetail(String addressDetail) {
			this.addressDetail = addressDetail;
			return this;
		}
		
		public UserBuilder regDate(String regDate) {
			this.regDate = regDate;
			return this;
		}
		
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public UserBuilder tel(String tel) {
			this.tel = tel;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
}


