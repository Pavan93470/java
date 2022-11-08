package com.evoke.corejava.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.evoke.corejava.model.StudentDto;
import com.evoke.corejava.service.Student;

@Service
public class StudentServiceImpl implements Student {
	private static final Logger logger = LogManager.getLogger(StudentServiceImpl.class);

	List<StudentDto> studentlist = new ArrayList<StudentDto>();

	@PostConstruct
	public void init() {

		StudentDto StudentDto1 = new StudentDto(1, "roja", "rbattila@evoketechnologies.com", 90, "male");
		StudentDto StudentDto2 = new StudentDto(2, "varma", "varma12@gmail.com", 89, "male");
		StudentDto StudentDto3 = new StudentDto(3, "vikas", "vikas@gmail.com", 95, "male");
		StudentDto StudentDto4 = new StudentDto(4, "ayappa", "ayappa12@gmail.com", 99, "male");
		StudentDto StudentDto5 = new StudentDto(5, "sailaja", "sailajagmail.com", 80, "female");
		StudentDto StudentDto6 = new StudentDto(6, "divya", "divyagmail.com", 82, "female");

		studentlist.add(StudentDto1);
		studentlist.add(StudentDto2);
		studentlist.add(StudentDto3);
		studentlist.add(StudentDto4);
		studentlist.add(StudentDto5);
		studentlist.add(StudentDto6);

	}

	@Override
	public List<StudentDto> getallstudent() {
		logger.info("get all student details");
		return studentlist;
	}

	@Override
	public List<StudentDto> filteringallstudentdetails() {
		List<StudentDto> filteredstudent = studentlist.stream()
				.filter(student -> student.getStudentgender().equalsIgnoreCase("male")).collect(Collectors.toList());

		logger.info("get filtered studentdetails");
		return filteredstudent;
	}

	@Override
	public String getstudentsbynames() {
		String filterbyname = studentlist.stream().map(StudentDto::getStudentname).collect(Collectors.joining(","))
				.toString();
		logger.info("getstudentsbynames studentdetails");
		return filterbyname;
	}

	@Override
	public List<StudentDto> updatedmarks(int midmarks) {
		studentlist.stream().forEach(student -> {
			int finalmarks = student.getStudentmarks();
			int totalmarks = finalmarks + midmarks;
			student.setStudentmarks(totalmarks);
		});
		logger.info(" updatedmarks");
		return studentlist;
	}

	@Override
	public List<Integer> allstudentmarks() {
		List<Integer> studentmarks = studentlist.stream().filter(p -> p.studentmarks > 80)// filtering data
				.map(p -> p.studentmarks) // fetching details
				.collect(Collectors.toList()); // collecting as list
		logger.info("get  allstudentmarks");
		return studentmarks;
	}

	@Override
	public Optional<StudentDto> getmaxmarks() {
		Optional<StudentDto> maxStudentmarks = studentlist.stream()
				.collect(Collectors.maxBy(Comparator.comparing(StudentDto::getStudentmarks)));
		logger.info("get  maxstudentmarks");

		return maxStudentmarks;

	}

	@Override
	public Optional<StudentDto> getminmarks() {
		Optional<StudentDto> minStudentmarks = studentlist.stream()
				.collect(Collectors.minBy(Comparator.comparing(StudentDto::getStudentmarks)));
		logger.info("get  minstudentmarks");
		return minStudentmarks;
	}

	@Override
	public List<StudentDto> searchbyname(String text) {
		logger.info("search by name");
		return studentlist.stream().filter(student -> student.getStudentname().startsWith(text))
				.collect(Collectors.toList());

	}

}
