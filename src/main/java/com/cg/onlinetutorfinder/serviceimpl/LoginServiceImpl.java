package com.cg.onlinetutorfinder.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetutorfinder.domain.User;
import com.cg.onlinetutorfinder.repository.UserRepository;
import com.cg.onlinetutorfinder.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findByUserEmail(String userEmail) {
		
		return userRepository.findByUserEmail(userEmail);
	}

	
}
