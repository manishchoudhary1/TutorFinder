package com.cg.onlinetutorfinder.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetutorfinder.domain.TutorSubjectMapping;
import com.cg.onlinetutorfinder.repository.TutorSubjectMappingRepository;
import com.cg.onlinetutorfinder.service.TutorSubjectMappingService;

@Service
public class TutorSubjectMappingServiceImpl implements TutorSubjectMappingService {
	
	@Autowired
	TutorSubjectMappingRepository tutorSubjectMappingRepository;

	@Override
	public  TutorSubjectMapping findByUserIdAndSubjectId(Long tutorId, Long subjectId) {

			TutorSubjectMapping tutorSubjectMapping = tutorSubjectMappingRepository.findByUserIdAndSubjectId(tutorId,subjectId);
		
		return tutorSubjectMapping;
		
	}

	@Override
	public List<TutorSubjectMapping> mapTutorToSubject(List<TutorSubjectMapping> tutorSubjectMappingList) {
		// TODO Auto-generated method stub
		return tutorSubjectMappingRepository.saveAllAndFlush(tutorSubjectMappingList);
	}

	@Override
	public List<TutorSubjectMapping> findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return tutorSubjectMappingRepository.findByUserId(userId);
	}



	

}
