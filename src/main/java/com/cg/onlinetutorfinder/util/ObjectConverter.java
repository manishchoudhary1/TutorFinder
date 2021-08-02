package com.cg.onlinetutorfinder.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlinetutorfinder.domain.DemoRequest;
import com.cg.onlinetutorfinder.domain.TutorRegister;
import com.cg.onlinetutorfinder.domain.TutorSubjectMapping;
import com.cg.onlinetutorfinder.domain.User;
import com.cg.onlinetutorfinder.dto.DemoRequestDto;
import com.cg.onlinetutorfinder.dto.SubjectDto;
import com.cg.onlinetutorfinder.dto.TutorBookDto;
import com.cg.onlinetutorfinder.dto.TutorDto;
import com.cg.onlinetutorfinder.dto.TutorRegisterDto;
import com.cg.onlinetutorfinder.dto.TutorSubjectDto;
import com.cg.onlinetutorfinder.dto.UserDto;
import com.cg.onlinetutorfinder.dto.UserRegisterDto;

@Component
public class ObjectConverter {
	
	@Autowired
	ModelMapper modelMapper;
	
	public TutorBookDto getDtoFromTutorRegister(TutorRegister tutorRegister, TutorSubjectMapping tutorSubjectMap) 
	{
		TutorBookDto tutorBookDto = modelMapper.map(tutorRegister, TutorBookDto.class);
		TutorSubjectDto tutorSubjectDto = new TutorSubjectDto();
		tutorSubjectDto.setSubjectId(tutorSubjectMap.getSubjectId());
		tutorSubjectDto.setTutorId(tutorSubjectMap.getUserId());
		tutorSubjectDto.setSubjectName(tutorSubjectMap.getSubjectName());
		tutorSubjectDto.setTutorName(tutorSubjectMap.getName());
		tutorBookDto.setTutorSubject(tutorSubjectDto);
		return tutorBookDto;
	}
	
	public TutorRegister getTutorRegisterFromDto(TutorBookDto tutorBookDto, Long tutorSubjectMapId) 
	{
		TutorRegister tutorRegister = modelMapper.map(tutorBookDto, TutorRegister.class);
		tutorRegister.setTutorSupjectMapId(tutorSubjectMapId);
		return tutorRegister;
		
		
	}

	public DemoRequest getDemoRequestFromDto(DemoRequestDto demoRequestDto, Long tutorSubjectMapId) {

		DemoRequest demoRequest = modelMapper.map(demoRequestDto, DemoRequest.class);
		demoRequest.setTutorSupjectMapId(tutorSubjectMapId);
		return demoRequest;
	}

	public DemoRequestDto getDtoFromDemoRequest(DemoRequest demoRequest, TutorSubjectMapping tutorSubjectMap) {
		
		DemoRequestDto demoRequestDto = modelMapper.map(demoRequest, DemoRequestDto.class);
		TutorSubjectDto tutorSubjectDto = new TutorSubjectDto();
		tutorSubjectDto.setSubjectId(tutorSubjectMap.getSubjectId());
		tutorSubjectDto.setTutorId(tutorSubjectMap.getUserId());
		tutorSubjectDto.setSubjectName(tutorSubjectMap.getSubjectName());
		tutorSubjectDto.setTutorName(tutorSubjectMap.getName());
		demoRequestDto.setTutorSubject(tutorSubjectDto);
		return demoRequestDto;
	}

	public User getUserFromTutorRegisterDto(TutorRegisterDto tutorRegisterDto) {
		return null;
	}

	public UserDto getUserDtoFromUser(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	public User getUserFromTutorDto(TutorDto tutorDto, User user) {
		user.setfName(tutorDto.getfName());
		user.setlName(tutorDto.getlName());
		user.setActive(tutorDto.getActive());
		user.setUserEmail(tutorDto.getUserEmail());
		return user;
	}

	public TutorSubjectMapping getTutorSubjectMappingFromTutorSubjectDto(TutorSubjectDto tutorSubjectDto) {
		TutorSubjectMapping tutorSubjectMapping = new TutorSubjectMapping();
		tutorSubjectMapping.setSubjectId(tutorSubjectDto.getSubjectId());
		tutorSubjectMapping.setUserId(tutorSubjectDto.getTutorId());
		return tutorSubjectMapping;
	}

	public User getUserFromUserRegisterDto(UserRegisterDto userRegisterDto) {
		// TODO Auto-generated method stub
		return modelMapper.map(userRegisterDto, User.class);
	}

}
