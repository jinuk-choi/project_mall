package com.project.example.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.example.domain.KakaoPayApprovalVO;
import com.project.example.domain.Order;
import com.project.example.service.KakaoPay;
import com.project.example.service.KakaoService;
import com.project.example.service.OrderService;

import lombok.Setter;

@RestController
@RequestMapping("/")
public class KakaoController {
	
	@Autowired
    private KakaoService kakao;
	
	@Autowired
    private KakaoPay kakaopay;
	
	@Autowired
	OrderService orderService;
    
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
	
	@GetMapping("/kakaoPay")
    public void kakaoPayGet() {
        
    }
    
    @PostMapping("/kakaoPay")
    public String kakaoPay(@RequestBody Order order) {
    	Order orderDetail = orderService.readOrderDetails(order);
    	System.out.println("kakaoPay post........................");
        
        return kakaopay.kakaoPayReady(orderDetail);
 
    }
    
    @GetMapping("/kakaoPaySuccess")
    public ResponseEntity<?> kakaoPaySuccess( @RequestParam("id") int id,
    										  @RequestParam("pg_token") String pg_token,
    										  Order order) {
    	System.out.println("kakaoPaySuccess get............................................");
    	System.out.println("kakaoPaySuccess pg_token : " + pg_token);
    	System.out.println("kakaoPaySuccess id : " + id);
    	
    	order.setId(id);
    	Order orderDetail = orderService.readOrderDetails(order);
    	
    	KakaoPayApprovalVO params =kakaopay.kakaoPayInfo(pg_token,orderDetail);
    	orderService.updateState(orderDetail);
    	
    	return new ResponseEntity<>(params, HttpStatus.OK);
        
        
    }
	
	
	
}
