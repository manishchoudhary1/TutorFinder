package com.cg.onlinetutorfinder.service;

import java.util.List;

import com.cg.onlinetutorfinder.domain.Subject;

public interface SubjectService {

	Subject save(Subject sub);

	List<Subject> getAllSubjects();

	Subject findBySubjectName(String subjectName);

	

}
