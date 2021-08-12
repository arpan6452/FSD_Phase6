package com.app.dto;

public class LoginResponseVO {
	private String key;
	private String username;
	private String role;
	private long expiresIn;
	
	public LoginResponseVO(String key, String username, String role, long expiresIn) {
		this.key = key;
		this.username = username;
		this.expiresIn = expiresIn;
		this.role = role;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
