package com.spo.service.showuniversities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.model.entity.University;
import com.spo.repository.university.UniversityRepository;

@Service
@Transactional(readOnly = true)
public class ShowUniversitiesServiceImpl implements ShowAllUniversitiesService
{
	@Autowired
	private UniversityRepository universityRepository;

	public List<University> getAllUniversities() 
	{
		return	universityRepository.getAllUniversities();
	}
	
}
