package com.example.jsp02.day04.entity;

public class User {
	
	private String id;
	private String password;
	private String name;
	private String email;
	
	public User(String id, String password, String name, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "[" + id + " , " + password + " , " + name + " , " + email + "]";
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
	
	public String getEmail() {
		return email;
	}
}
