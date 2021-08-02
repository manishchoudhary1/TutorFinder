package com.cg.onlinetutorfinder.service;

import com.cg.onlinetutorfinder.domain.User;

public interface LoginService  {

	User findByUserEmail(String userEmail);

}
