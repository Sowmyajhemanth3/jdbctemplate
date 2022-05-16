package com.src.dao;

import java.util.List;

import com.src.bean.Student;

public interface StudentDAOInterface {
	
public int insertStudent(Student s);
public int deleteStudent(Student s);
public int editStudent(Student s);
	
public List<Student> getAllStudents();
public List<Student> getStudentById(String sid);	
}
