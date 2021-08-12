package com.app.dto;

public class UpdatePasswordVO {
	private String oldpassword;
	private String newpassword;
	private String username;
	
	public UpdatePasswordVO(String oldpassword, String newpassword, String username) {
		super();
		this.oldpassword = oldpassword;
		this.newpassword = newpassword;
		this.username = username;
	}
	
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
