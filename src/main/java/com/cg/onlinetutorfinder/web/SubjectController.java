package com.cg.onlinetutorfinder.web;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetutorfinder.domain.Subject;
import com.cg.onlinetutorfinder.domain.User;
import com.cg.onlinetutorfinder.dto.SubjectDto;
import com.cg.onlinetutorfinder.service.SubjectService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class SubjectController {

	
	@Autowired
	SubjectService subjectService;
	@Autowired
	ModelMapper modelMapper;
	
	ResponseEntity<?> responseEntity;
	@ApiOperation(value = "Saves the subject in the repository", response = SubjectDto.class, authorizations = {@Authorization(value="Authorization")})
	@PostMapping("/saveSubject")
	public ResponseEntity saveSubject(@RequestBody SubjectDto sub)
	{
		Subject subject = modelMapper.map(sub, Subject.class);
		subject = subjectService.save(subject);
		sub = modelMapper.map(subject, SubjectDto.class);
		return new ResponseEntity(sub, HttpStatus.OK);
		
	}
	@ApiOperation(value = "Gets all the subject from the repository", response = Subject.class,responseContainer = "List", authorizations = {@Authorization(value="Authorization")})
	@GetMapping("/getAllSubjects")
	public ResponseEntity getAllSubjects()
	{
		List<Subject> allSubjects = subjectService.getAllSubjects();
		return new ResponseEntity(allSubjects, HttpStatus.OK);
	}
	@ApiOperation(value = "Gets the subject according to the name from the repository", response = Subject.class, authorizations = {@Authorization(value="Authorization")})
	@GetMapping("/getSubjectByName")
	public ResponseEntity getSubjectsByName(@RequestParam("subjectName") String subjectName)
	{
		Subject subject = subjectService.findBySubjectName(subjectName);
		return new ResponseEntity(subject, HttpStatus.OK);
	}
	
	
}
