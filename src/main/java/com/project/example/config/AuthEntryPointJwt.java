package com.project.example.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//WebSecurityConfig.java 클래스에서 셋팅 될시 에러가 발생하면 에러처리를 하기 위해 사용된다. 

@Component 
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException{
		System.out.println("체크  AuthEntryPointJwt");
		logger.error("Unauthorized error:{}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}
	
	
}
