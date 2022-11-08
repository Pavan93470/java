package com.evoke.corejava.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.corejava.model.StudentDto;
import com.evoke.corejava.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/api")
public class StudentController {
	private static final Logger logger = LogManager.getLogger(StudentController.class);
	@Autowired
	private StudentServiceImpl StudentServiceImpl;

	@GetMapping("/student")
	public List<StudentDto> getallstudents() {
		logger.info("all student details");
		return StudentServiceImpl.getallstudent();

	}

	@GetMapping("filter/students")
	public List<StudentDto> getfilteredstudent() {
		logger.info("All student filter details");
		return StudentServiceImpl.filteringallstudentdetails();

	}

	@GetMapping("student/name")
	public String getemployeebyname() {
		logger.info("get student by name");
		return StudentServiceImpl.getstudentsbynames();

	}

	@GetMapping("student/marks")
	public List<StudentDto> updatedmarks() {
		logger.info("updated marks");
		int midmarks = 20;
		return StudentServiceImpl.updatedmarks(midmarks);

	}

	@GetMapping("student/getmarks")

	public List<Integer> getmarkslist() {
		logger.info("get all studentsmarks");

		return StudentServiceImpl.allstudentmarks();

	}

	@GetMapping("student/getmaxmarks")
	public Optional<StudentDto> getmaxmarks() {
		logger.info("max marks");
		return StudentServiceImpl.getmaxmarks();

	}

	@GetMapping("student/getminmarks")
	public Optional<StudentDto> getminmarks() {
		logger.info("min marks");
		return StudentServiceImpl.getminmarks();

	}

	@GetMapping("student/serachbyname/{searchtext}")
	public List<StudentDto> searchbyname(@PathVariable String searchtext) {
		return StudentServiceImpl.searchbyname(searchtext);

	}
}
