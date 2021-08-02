package com.cg.onlinetutorfinder.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetutorfinder.domain.Subject;
import com.cg.onlinetutorfinder.repository.SubjectRepository;
import com.cg.onlinetutorfinder.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public Subject save(Subject sub) {
		// TODO Auto-generated method stub
		return subjectRepository.save(sub);
	}

	@Override
	public List<Subject> getAllSubjects() {
		
		return subjectRepository.findAll();
	}

	@Override
	public Subject findBySubjectName(String subjectName) {
		// TODO Auto-generated method stub
		return subjectRepository.findBySubjectName(subjectName);
	}	
}
