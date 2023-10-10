package com.example.jsp02.dto;

public class NewBoardDTO {
	
	private int no, hit, re_group, re_level, re_step, available;
	private String id, name, title, content, reg_date;
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getHit() {
		return hit;
	}
	
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public int getReGroup() {
		return re_group;
	}
	
	public void setReGroup(int re_group) {
		this.re_group = re_group;
	}
	
	public int getReLevel() {
		return re_level;
	}
	
	public void setReLevel(int re_level) {
		this.re_level = re_level;
	}
	
	public int getReStep() {
		return re_step;
	}
	
	public void setReStep(int re_step) {
		this.re_step = re_step;
	}
	
	public int getAvailable() {
		return available;
	}
	
	public void setAvailable(int available) {
		this.available = available;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getRegDate() {
		return reg_date;
	}
	
	public void setRegDate(String reg_date) {
		this.reg_date = reg_date;
	}
	
	public NewBoardDTO() {
		super();
	}
	
	public NewBoardDTO(int no, int hit, int re_group, int re_level, int re_step, int available,
			String id,
			String name, String title, String content, String reg_date) {
		super();
		this.no = no;
		this.hit = hit;
		this.re_group = re_group;
		this.re_level = re_level;
		this.re_step = re_step;
		this.available = available;
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "NewBoardDTO{" +
				"no=" + no +
				", hit=" + hit +
				", re_group=" + re_group +
				", re_level=" + re_level +
				", re_step=" + re_step +
				", available=" + available +
				", id='" + id + '\'' +
				", name='" + name + '\'' +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", reg_date='" + reg_date + '\'' +
				'}';
	}
}
