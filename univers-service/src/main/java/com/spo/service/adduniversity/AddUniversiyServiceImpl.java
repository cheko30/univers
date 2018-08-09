package com.spo.service.adduniversity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spo.model.entity.University;
import com.spo.repository.university.UniversityRepository;

@Service
@Transactional(readOnly = true)
public class AddUniversiyServiceImpl implements AddUnivesityService
{
	@Autowired
	private UniversityRepository universityRepository;

	@Transactional
	public void addUniversity(University universityDAO) 
	{
		University university = new University();
		university.setUniversityName(universityDAO.getUniversityName());
		university.setUniversityCountry(universityDAO.getUniversityCountry());
		university.setUniversityCity(universityDAO.getUniversityCity());
		
		universityRepository.save(university);
		
	}

}
