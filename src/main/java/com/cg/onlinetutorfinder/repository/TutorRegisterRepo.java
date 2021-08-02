package com.cg.onlinetutorfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinetutorfinder.domain.DemoRequest;
import com.cg.onlinetutorfinder.domain.TutorRegister;

@Repository
public interface TutorRegisterRepo extends JpaRepository<TutorRegister, Long> {

	@Query(value = "select * from tutor_register where tutor_subject_map_tutor_subject_map_id "
			+ "in"
			+ " (select tutor_subject_map_id from tutor_subject_mapping where user_user_id = :tutorId)",nativeQuery = true )
	List<TutorRegister> findByTutorId(Long tutorId);
	
	List<TutorRegister> findByParentId(Long parentId);
	
	@Query(value = "select * from tutor_register where tutor_subject_map_tutor_subject_map_id "
			+ "in"
			+ " (select tutor_subject_map_id from tutor_subject_mapping where subject_subject_id = :subjectId)",nativeQuery = true )
	List<TutorRegister> findBySubjectId(Long subjectId);

	
}
