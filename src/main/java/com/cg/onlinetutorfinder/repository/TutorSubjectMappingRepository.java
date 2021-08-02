package com.cg.onlinetutorfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinetutorfinder.domain.TutorSubjectMapping;

@Repository
public interface TutorSubjectMappingRepository extends JpaRepository<TutorSubjectMapping, Long> {

	List<TutorSubjectMapping> findByUserId(Long userId);

	TutorSubjectMapping findByUserIdAndSubjectId(Long tutorId, Long subjectId);
}
