package com.cg.onlinetutorfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinetutorfinder.domain.DemoRequest;
import com.cg.onlinetutorfinder.domain.TutorSubjectMapping;

@Repository
public interface DemoRepository extends JpaRepository<DemoRequest, Long> {
	
	@Query(value = "select * from demo_request where tutor_subject_map_tutor_subject_map_id "
			+ "in"
			+ " (select tutor_subject_map_id from tutor_subject_mapping where user_user_id = :tutorId)",nativeQuery = true )
	List<DemoRequest> findByTutorId(Long tutorId);
	
	List<DemoRequest> findByParentId(Long parentId);

}