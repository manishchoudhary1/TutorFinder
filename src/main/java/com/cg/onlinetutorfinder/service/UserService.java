package com.cg.onlinetutorfinder.service;

import java.util.List;

import com.cg.onlinetutorfinder.domain.DemoRequest;
import com.cg.onlinetutorfinder.domain.TutorRegister;
import com.cg.onlinetutorfinder.domain.TutorSubjectMapping;
import com.cg.onlinetutorfinder.domain.User;

public interface UserService  {

	User save(User user);

	User find(String userEmail);

	List<User> findAll();

	List<User> findByUserType(String userType);

	DemoRequest saveDemo(DemoRequest demoRequest);

	List<DemoRequest> findAllDemo();
	List<DemoRequest> findByTutorSubjectMap(Long tutorId);
	List<DemoRequest> findDemoByParentId(Long parentId);

	DemoRequest updateDemoStatus(Long demoId, String demoStatus);

	TutorRegister registerTutor(TutorRegister tutorRegister);

	List<TutorRegister> findAllTutorRegistration();

	List<TutorRegister> findRegistrationByParentId(Long id);

	List<TutorRegister> findRegistrationByTutorId(Long tutorId);

	List<TutorRegister> findRegistrationBySubjectId(Long subjectId);

	List<DemoRequest> findDemoByTutorId(Long tutorId);

	User findById(Long userId);


}
