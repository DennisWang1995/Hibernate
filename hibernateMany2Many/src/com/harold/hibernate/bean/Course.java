package com.harold.hibernate.bean;

import java.util.Set;

public class Course {
	private Integer cou_id;
	private String cou_name;
	private Set<Student> students;
	public Integer getCou_id() {
		return cou_id;
	}
	public void setCou_id(Integer cou_id) {
		this.cou_id = cou_id;
	}
	public String getCou_name() {
		return cou_name;
	}
	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
