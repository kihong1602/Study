package com.example.jsp02.dto;

public class ReplyBoardDTO {
	
	private int no, hit, reGroup, reLevel, reStep, available;
	private String id, name, title, content, regDate;
	
	public ReplyBoardDTO(Builder builder) {
		this.no = builder.no;
		this.id = builder.id;
		this.name = builder.name;
		this.title = builder.title;
		this.content = builder.content;
		this.hit = builder.hit;
		this.reGroup = builder.reGroup;
		this.reLevel = builder.reLevel;
		this.reStep = builder.reStep;
		this.regDate = builder.regDate;
		this.available = builder.available;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public void setReGroup(int reGroup) {
		this.reGroup = reGroup;
	}
	
	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}
	
	public void setReStep(int reStep) {
		this.reStep = reStep;
	}
	
	public void setAvailable(int available) {
		this.available = available;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public int getNo() {
		return no;
	}
	
	public int getHit() {
		return hit;
	}
	
	public int getReGroup() {
		return reGroup;
	}
	
	public int getReLevel() {
		return reLevel;
	}
	
	public int getReStep() {
		return reStep;
	}
	
	public int getAvailable() {
		return available;
	}
	
	public String getId() {
		return id;
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
		
		private int no, hit, reGroup, reLevel, reStep, available;
		private String id, name, title, content, regDate;
		
		public Builder(String id) {
			this.id = id;
		}
		
		public Builder no(int no) {
			this.no = no;
			return this;
		}
		
		public Builder hit(int hit) {
			this.hit = hit;
			return this;
		}
		
		public Builder reGroup(int reGroup) {
			this.reGroup = reGroup;
			return this;
		}
		
		public Builder reLevel(int reLevel) {
			this.reLevel = reLevel;
			return this;
		}
		
		public Builder reStep(int reStep) {
			this.reStep = reStep;
			return this;
		}
		
		public Builder available(int available) {
			this.available = available;
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
		
		public ReplyBoardDTO build() {
			return new ReplyBoardDTO(this);
		}
		
	}
}
