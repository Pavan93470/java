package com.evoke.corejava.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentDto {
	private static final Logger logger = LogManager.getLogger(StudentDto.class);

	public int studentid;
	private String studentname;
	private String studentmailid;
	public int studentmarks;
	private String studentgender;

	public StudentDto(int studentid, String studentname, String studentmailid, int studentmarks, String studentgender) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentmailid = studentmailid;
		this.studentmarks = studentmarks;
		this.studentgender = studentgender;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentmailid() {
		return studentmailid;
	}

	public void setStudentmailid(String studentmailid) {
		this.studentmailid = studentmailid;
	}

	public int getStudentmarks() {
		return studentmarks;
	}

	public void setStudentmarks(int studentmarks) {
		this.studentmarks = studentmarks;
	}

	public String getStudentgender() {
		return studentgender;
	}

	public void setStudentgender(String studentgender) {
		this.studentgender = studentgender;
	}

	@Override
	public String toString() {
		return "StudentDto [studentid=" + studentid + ", studentname=" + studentname + ", studentmailid="
				+ studentmailid + ", studentmarks=" + studentmarks + ", studentgender=" + studentgender + "]";
	}

}
