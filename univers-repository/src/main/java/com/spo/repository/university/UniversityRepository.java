package com.spo.repository.university;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spo.model.entity.University;

@Repository
public interface UniversityRepository extends JpaRepository<University,Integer>
{
	@Query("select u from University u order by u.universityName")
	List<University> getAllUniversities();
	
	@Query("select count(s) from Student s where s.university.id=:universityId")
	Integer getNumberOfStudentsForUniversity(@Param("universityId") Integer universityId);

}
