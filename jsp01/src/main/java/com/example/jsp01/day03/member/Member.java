package com.example.jsp01.day03.member;

public class Member {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	
	public Member(String id, String pw, String name, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return "[" + id + " , " + name + " , " + email + "]";
	}
}
