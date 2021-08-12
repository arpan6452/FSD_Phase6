package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
            })})
@ApiModel(description="Entity class of user.User can be buyer or admin based on credentials and role set during the time of registration the user will be treated accordingly.")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "ID of the user.It is the primery key and auto generated.",name="user ID",required=true,value="1")
	private int userId;
	
	@ApiModelProperty(notes = "Name of the user.",required=true, value="Arpan Ghosh")
	private String username;
	@ApiModelProperty(notes = "Password of the user's account.",required=true, value="Password@123")
	private String password;
	@ApiModelProperty(notes = "Address line1 of the user.",required=true, value="205, Amedanman Aprt.")
	private String address1;
	@ApiModelProperty(notes = "Address line1 of the user.",required=true, value="Uttarhalli Main road, Bangalore, Karnataka")
	private String address2;
	@ApiModelProperty(notes = "Name of the city the user belongs to.",required=true, value="Bangalore")
	private String city;
	@ApiModelProperty(notes = "Name of the state the user belongs to..",required=true, value="Karnataka")
	private String state;
	@ApiModelProperty(notes = "Pincode of the state the user belongs to.",required=true, value="560098")
	private long pincode;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_roles")
	@ApiModelProperty(notes = "Role of the user.",required=true, value="ADMIN/USER")
    private Role role;
	

	public User() {
	}

	public User(Role role, String username, String password, String address1, String address2, String city,
			String state, long pincode) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getUserId() {
		return userId;
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
