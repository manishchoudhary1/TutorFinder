package com.cg.onlinetutorfinder.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetutorfinder.domain.DemoRequest;
import com.cg.onlinetutorfinder.domain.TutorRegister;
import com.cg.onlinetutorfinder.domain.TutorSubjectMapping;
import com.cg.onlinetutorfinder.domain.User;
import com.cg.onlinetutorfinder.dto.DemoRequestDto;
import com.cg.onlinetutorfinder.dto.ParentDto;
import com.cg.onlinetutorfinder.dto.TutorBookDto;
import com.cg.onlinetutorfinder.dto.TutorSubjectDto;
import com.cg.onlinetutorfinder.dto.UserDto;
import com.cg.onlinetutorfinder.dto.UserRegisterDto;
import com.cg.onlinetutorfinder.repository.TutorSubjectMappingRepository;
import com.cg.onlinetutorfinder.service.TutorSubjectMappingService;
import com.cg.onlinetutorfinder.service.UserService;
import com.cg.onlinetutorfinder.util.ObjectConverter;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class ParentController {

	
	@Autowired
	UserService userService;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	TutorSubjectMappingService tutorSubjectMappingService;
	@Autowired
	ObjectConverter objectConverter;
	
	
	
	ResponseEntity<?> responseEntity;
	
	@ApiOperation(value = "Save the parent in the repository", response = ParentDto.class)
	@PostMapping("parent/save")
	public ResponseEntity saveOrUpdateParent(@RequestBody UserRegisterDto userRegisterDto)
	{
		User user = modelMapper.map(userRegisterDto, User.class);
		user.setUserType("parent");
		user = userService.save(user);
		ParentDto parent = modelMapper.map(user, ParentDto.class);
		return new ResponseEntity(parent, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get the parent details from the repository", response = ParentDto.class, authorizations = {@Authorization(value="Authorization")})
	@GetMapping("parent/user")
	public ResponseEntity getUserByEmail(@RequestParam("user") String userEmail)
	{
		
		User user = userService.find(userEmail);
		ParentDto parent = modelMapper.map(user, ParentDto.class);
		return new ResponseEntity(parent, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Save the demo request in the repository", response = DemoRequestDto.class, authorizations = {@Authorization(value="Authorization")})
	@PostMapping("parent/saveDemo")
	public ResponseEntity saveOrDemo(@RequestBody DemoRequestDto demoRequestDto)
	{
		TutorSubjectMapping tutorSubjectMap = tutorSubjectMappingService.findByUserIdAndSubjectId(demoRequestDto.getTutorSubject().getTutorId(),demoRequestDto.getTutorSubject().getSubjectId());
		DemoRequest demoRequest = objectConverter.getDemoRequestFromDto(demoRequestDto,tutorSubjectMap.getTutorSubjectMapId());
		demoRequest = userService.saveDemo(demoRequest);
		demoRequestDto = objectConverter.getDtoFromDemoRequest(demoRequest,tutorSubjectMap);
		return new ResponseEntity(demoRequestDto, HttpStatus.OK);
	}
		
	
	@ApiOperation(value = "Gets all the demos according to the parent id from the repository", response = DemoRequestDto.class,responseContainer = "List", authorizations = {@Authorization(value="Authorization")})
	@GetMapping("parent/getDemoByParentId")
	public ResponseEntity getDemoByParentId(@RequestParam("parentId") Long id)
	{
		List<DemoRequest> getAllDemos = userService.findDemoByParentId(id);

		List<DemoRequestDto> allDemoList = new ArrayList<>();
		for(DemoRequest demo : getAllDemos)
		{
			DemoRequestDto demoRequestDto = objectConverter.getDtoFromDemoRequest(demo,demo.getTutorSubjectMap());
			allDemoList.add(demoRequestDto);
		}
	
		return new ResponseEntity(allDemoList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Register the tutor", response = TutorBookDto.class, authorizations = {@Authorization(value="Authorization")})
	@PostMapping("parent/registerTutor")
	public ResponseEntity registerTutor(@RequestBody TutorBookDto tutorBookDto)
	{
		TutorSubjectMapping tutorSubjectMap = tutorSubjectMappingService.findByUserIdAndSubjectId(tutorBookDto.getTutorSubject().getTutorId(),tutorBookDto.getTutorSubject().getSubjectId());
		TutorRegister tutorRegister = objectConverter.getTutorRegisterFromDto(tutorBookDto,tutorSubjectMap.getTutorSubjectMapId());
		tutorRegister = userService.registerTutor(tutorRegister);
		tutorBookDto = objectConverter.getDtoFromTutorRegister(tutorRegister,tutorSubjectMap);
		return new ResponseEntity(tutorBookDto, HttpStatus.OK);
	}

	
	@ApiOperation(value = "Gets all the registration according to the parent id from the repository", response = TutorBookDto.class,responseContainer = "List", authorizations = {@Authorization(value="Authorization")})
	@GetMapping("parent/getRegistrationByParentId")
	public ResponseEntity getRegistrationByParentId(@RequestParam("parentId") Long id)
	{
		List<TutorRegister> allRegistrationByParentIdList = userService.findRegistrationByParentId(id);
		List<TutorBookDto> allTutorRegistration = new ArrayList<>();
		for(TutorRegister tutorRegister : allRegistrationByParentIdList)
		{
			TutorBookDto tutorBookDto = objectConverter.getDtoFromTutorRegister(tutorRegister,tutorRegister.getTutorSubjectMap());
			allTutorRegistration.add(tutorBookDto);
		}
	
		return new ResponseEntity(allTutorRegistration, HttpStatus.OK);
	}
	
}
