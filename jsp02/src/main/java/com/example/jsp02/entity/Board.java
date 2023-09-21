package com.example.jsp02.entity;

public class Board {
	
	private int no, hit;
	private String id, password, name, title, content, regDate;
	
	public Board(Builder builder) {
		this.no = builder.no;
		this.id = builder.id;
		this.password = builder.password;
		this.name = builder.name;
		this.title = builder.title;
		this.content = builder.content;
		this.regDate = builder.regDate;
		this.hit = builder.hit;
	}
	
	public int getNo() {
		return no;
	}
	
	public int getHit() {
		return hit;
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
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public static class Builder {
		
		private int no, hit;
		private String id, password, name, title, content, regDate;
		
		public Builder(String password) {
			this.password = password;
		}
		
		public Builder no(int no) {
			this.no = no;
			return this;
		}
		
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder content(String content) {
			this.content = content;
			return this;
		}
		
		public Builder regDate(String regDate) {
			this.regDate = regDate;
			return this;
		}
		
		public Builder hit(int hit) {
			this.hit = hit;
			return this;
		}
		
		public Board build() {
			return new Board(this);
		}
	}
}
