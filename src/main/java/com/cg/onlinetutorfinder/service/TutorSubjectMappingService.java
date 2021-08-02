package com.cg.onlinetutorfinder.service;

import java.util.List;

import com.cg.onlinetutorfinder.domain.TutorSubjectMapping;

public interface TutorSubjectMappingService {

	TutorSubjectMapping findByUserIdAndSubjectId(Long tutorId, Long subjectId);

	List<TutorSubjectMapping> mapTutorToSubject(List<TutorSubjectMapping> tutorSubjectMappingList);

	List<TutorSubjectMapping> findByUserId(Long userId);

}
