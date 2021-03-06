package com.spo.service.addstudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.model.entity.Student;
import com.spo.repository.student.AddStudentRepository;


@Service
@Transactional(readOnly = true)
public class AddStudentServiceImpl implements AddStudentService
{
	@Autowired
	private AddStudentRepository addStudentRepository;

	@Transactional
	public void saveStudent(Student studentDAO) 
	{
		Student student = new Student();
		student.setFirstName(studentDAO.getFirstName());
		student.setLastName(studentDAO.getLastName());
		student.setAge(studentDAO.getAge());
		student.setGender(studentDAO.getGender());	
		student.setUniversity(studentDAO.getUniversity());
		
		addStudentRepository.save(student);
	}

}
