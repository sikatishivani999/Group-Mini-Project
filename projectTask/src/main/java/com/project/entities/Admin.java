package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	int id;
	String ProjectName;
	String UserEnrolled;
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getUserEnrolled() {
		return UserEnrolled;
	}
	public void setUserEnrolled(String userEnrolled) {
		UserEnrolled = userEnrolled;
	}
	@Override
	public String toString() {
		return "Admin [ProjectName=" + ProjectName + ", UserEnrolled=" + UserEnrolled + "]";
	}
	
	

}
