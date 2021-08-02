package com.cg.onlinetutorfinder.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetutorfinder.domain.DemoRequest;
import com.cg.onlinetutorfinder.domain.TutorRegister;
import com.cg.onlinetutorfinder.domain.TutorSubjectMapping;
import com.cg.onlinetutorfinder.domain.User;
import com.cg.onlinetutorfinder.repository.DemoRepository;
import com.cg.onlinetutorfinder.repository.SubjectRepository;
import com.cg.onlinetutorfinder.repository.TutorRegisterRepo;
import com.cg.onlinetutorfinder.repository.TutorSubjectMappingRepository;
import com.cg.onlinetutorfinder.repository.UserRepository;
import com.cg.onlinetutorfinder.service.UserService;


@Service
public class UserServiveImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	DemoRepository demorepository;
	@Autowired
	TutorSubjectMappingRepository tutorSubjectMappingRepo;
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	TutorRegisterRepo tutorRegisterRepo;
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User find(String userEmail) {
		
		return userRepository.findByUserEmail(userEmail);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findByUserType(String userType) {
		// TODO Auto-generated method stub
		return userRepository.findByUserType(userType);
	}

	@Override
	public DemoRequest saveDemo(DemoRequest demoRequest) {
		return demorepository.saveAndFlush(demoRequest);
	}

	public List findAllDemo() {
	
	return	demorepository.findAll();
	
	}

	@Override
	public List<DemoRequest> findByTutorSubjectMap(Long tutorId) {	
		return demorepository.findByTutorId(tutorId);
	}

	@Override
	public List<DemoRequest> findDemoByParentId(Long parentId) {
		
		return demorepository.findByParentId(parentId);
	}
	
	@Override
	public List<DemoRequest> findDemoByTutorId(Long tutorId) {
		
		return demorepository.findByTutorId(tutorId);
	}

	@Override
	public DemoRequest updateDemoStatus(Long demoId, String demoStatus) {
		
		DemoRequest demoRequest = null;
		Optional<DemoRequest> demoRequestContainer =  demorepository.findById(demoId);
		if(demoRequestContainer.isPresent())
		{
			demoRequest = demoRequestContainer.get();
			demoRequest.setStatus(demoStatus);
			demoRequest = demorepository.saveAndFlush(demoRequest);
		}
		return demoRequest;
	}

	@Override
	public TutorRegister registerTutor(TutorRegister tutorRegister) {
		 return tutorRegisterRepo.saveAndFlush(tutorRegister);	
	}

	@Override
	public List<TutorRegister> findAllTutorRegistration() {
		
		return tutorRegisterRepo.findAll();
	}

	@Override
	public List<TutorRegister> findRegistrationByParentId(Long parentId) {
		return tutorRegisterRepo.findByParentId(parentId);
	}

	@Override
	public List<TutorRegister> findRegistrationByTutorId(Long tutorId) {
		
		return tutorRegisterRepo.findByTutorId(tutorId);
	}

	@Override
	public List<TutorRegister> findRegistrationBySubjectId(Long subjectId) {
		
		return tutorRegisterRepo.findBySubjectId(subjectId);
	}

	@Override
	public User findById(Long userId) {
		
		Optional<User> optionalUser = userRepository.findById(userId);
		
		return optionalUser.get();
	}

}
