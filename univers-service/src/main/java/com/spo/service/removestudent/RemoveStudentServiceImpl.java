package com.spo.service.removestudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.model.entity.Student;
import com.spo.repository.removestudent.RemoveStudentRepository;

@Service
@Transactional(readOnly = true)
public class RemoveStudentServiceImpl implements RemoveStudentservice
{
	@Autowired
	private RemoveStudentRepository removeStudentRepository;

	@Transactional
	public void removeStudent(Student student) 
	{
		removeStudentRepository.delete(student);
		
	}
	
}
