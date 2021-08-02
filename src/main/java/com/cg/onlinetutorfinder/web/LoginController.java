package com.cg.onlinetutorfinder.web;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetutorfinder.domain.User;
import com.cg.onlinetutorfinder.dto.LoginUserDto;
import com.cg.onlinetutorfinder.dto.UserDto;
import com.cg.onlinetutorfinder.repository.UserRepository;
import com.cg.onlinetutorfinder.service.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
    @Autowired
    private ModelMapper modelMapper;
    
    
    ResponseEntity<?> responseEntity;
	
    @ApiOperation(value = "Enables Login and provides token", response = LoginUserDto.class)
    @PostMapping("login")
	public ResponseEntity<?> login(@RequestParam("user") String userEmail, @RequestParam("password") String pwd) {
		
		User user = loginService.findByUserEmail(userEmail);
		LoginUserDto userDto = null;
		if(user!=null)
		{
			if(pwd.equals(user.getPassword()))
			{
				
				String token = getJWTToken(userEmail);
				userDto = modelMapper.map(user, LoginUserDto.class);
				userDto.setToken(token);
				responseEntity = new ResponseEntity(userDto,HttpStatus.OK);
				
				
			}
			else
			{
				responseEntity = new ResponseEntity("Invalid Creds",HttpStatus.OK);
				
			}
		}
		else
		{
			responseEntity = new ResponseEntity("Invalid Creds",HttpStatus.OK);
			
		}
		
		return	responseEntity;
	}
		
		
	

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60000000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
	
	
	public String changePassword()
	{
		return null;
	}
}
