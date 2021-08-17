package com.project.example.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.example.service.KakaoService;

@RestController
@RequestMapping("/")
public class KakaoController {
	@Autowired
    private KakaoService kakao;
    
	@PostMapping("/klogin")
	public HashMap<String, Object> klogin(@RequestParam("authorize_code") String authorize_code, HttpSession session) {
	    String access_Token = kakao.getAccessToken(authorize_code);
	    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    
	    System.out.println("login Controller : " + userInfo);
	    
	    //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
	    if (userInfo.get("email") != null) {
	        session.setAttribute("userId", userInfo.get("email"));
	        session.setAttribute("access_Token", access_Token);
	   
	    }
	    	return userInfo;
	}
	
	
	
}
