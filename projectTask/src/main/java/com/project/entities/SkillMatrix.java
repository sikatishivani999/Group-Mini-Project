package com.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SkillMatrix")
public class SkillMatrix {
	
	
	@Column
	private String UserName;
	@Id
	private int UserId;
	@Column
	private String TechnicalSkill;
	private int YearOfExp;
	@Column
	private String project;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		this.UserId = userId;
	}
	public String getTechnicalSkill() {
		return TechnicalSkill;
	}
	public void setTechnicalSkill(String technicalSkill) {
		this.TechnicalSkill = technicalSkill;
	}
	public int getYearOfExp() {
		return YearOfExp;
	}
	public void setYearOfExp(int yearOfExp) {
		this.YearOfExp = yearOfExp;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public SkillMatrix() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SkillMatrix [UserName=" + UserName + ", UserId=" + UserId 	+ ", YearOfExp=" + YearOfExp + ", project=" + project + "]";
	}
	
}
