package com.project.example.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.project.example.domain.KakaoPayApprovalVO;
import com.project.example.domain.KakaoPayReadyVO;
import com.project.example.domain.Order;

import lombok.extern.java.Log;

 
@Service
@Log
public class KakaoPay {
 
    private static final String HOST = "https://kapi.kakao.com";
    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    
    public String kakaoPayReady(Order order) {
 
        RestTemplate restTemplate = new RestTemplate();
        
        //String dns = "http://localhost:8080";
        String dns = "http://yosinsa.com";
        
//        int price = Integer.parseInt(order.getPrice());
//        int count = Integer.parseInt(order.getCount());
//        int total = price * count;
       
        
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "2f4f3a2e204b0dfbafa3542bb663c25d");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("item_name", "YOSINSA");
        params.add("quantity", "1");
        params.add("total_amount", Integer.toString(order.getTotal_price()));
        params.add("tax_free_amount", "100");
        params.add("approval_url", dns + "/kakaoPaySuccess?id=" + Integer.toString(order.getId()));
        params.add("cancel_url", dns + "/kakaoPayCancel");
        params.add("fail_url", dns + "/kakaoPaySuccessFail");
 
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
 
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            
  
            return kakaoPayReadyVO.getNext_redirect_pc_url();
 
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "/pay";
        
    }
    
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token, Order order) {
    	 
        RestTemplate restTemplate = new RestTemplate();
        
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "2f4f3a2e204b0dfbafa3542bb663c25d");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
 
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("pg_token", pg_token);
        params.add("total_amount", Integer.toString(order.getTotal_price()) );
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
                
            return kakaoPayApprovalVO;
        
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
    
}