package com.project.example.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String username;
	private String name;
	private String email;
	private String phone;
	private String address;
	private List<String> roles;
	private String type = "Bearer";
	
	public JwtResponse(String jwt, String id, String u_name, String ph, String ad, String em, List<String> u_roles) {
		this.token = jwt;
		this.username = id;
		this.name = u_name;
		this.roles = u_roles;
		this.phone = ph;
		this.address = ad;
		this.email = em;
		
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getType() {
		return type;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", username=" + username + ", name=" + name + ", roles=" + roles + "]";
	}
		
}
