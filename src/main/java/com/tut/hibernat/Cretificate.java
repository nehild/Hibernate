package com.tut.hibernat;

import javax.persistence.Embeddable;

@Embeddable
public class Cretificate {
	
	private String course;
	private String duration;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Cretificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	public Cretificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
