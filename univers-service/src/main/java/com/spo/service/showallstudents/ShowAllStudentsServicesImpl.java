package com.spo.service.showallstudents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.model.entity.Student;
import com.spo.repository.student.AddStudentRepository;

@Service
@Transactional
public class ShowAllStudentsServicesImpl implements ShowAllStudentsService
{
	@Autowired
	private AddStudentRepository studentRepository;

	
	public List<Student> getAllStudents() 
	{
		return studentRepository.getAllStudents();
	}
	

}
