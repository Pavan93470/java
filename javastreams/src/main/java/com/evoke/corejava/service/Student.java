package com.evoke.corejava.service;

import java.util.List;
import java.util.Optional;

import com.evoke.corejava.model.StudentDto;

public interface Student {
	public List<StudentDto> getallstudent();

	public List<StudentDto> filteringallstudentdetails();

	public String getstudentsbynames();

	public List<StudentDto> updatedmarks(int midmarks);

	public List<Integer> allstudentmarks();

	public Optional<StudentDto> getmaxmarks();

	public Optional<StudentDto> getminmarks();

	public List<StudentDto> searchbyname(String text);

	

}
