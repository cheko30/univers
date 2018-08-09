package com.spo.service.universitystatitics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.repository.university.UniversityRepository;

@Service
@Transactional(readOnly = true)
public class UniversityStatiticsServiceImpl implements UniversityStatiticsService 
{
	@Autowired
	private UniversityRepository universityRepository;

	public Integer getNumOfStudentsForUniversity(Integer universityId) 
	{
		return universityRepository.getNumberOfStudentsForUniversity(universityId);
	}

}
