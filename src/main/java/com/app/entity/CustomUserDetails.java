package com.app.entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private long pincode;
	
	private GrantedAuthority authority;
	
	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomUserDetails(String username, String password, String address1, String address2, String city, String state,long pincode, GrantedAuthority authority) {
        
        this.username = username;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.authority = authority;
    }
	
	public static CustomUserDetails create(User user) {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleName().toString());

        return new CustomUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.getAddress1(),
                user.getAddress2(),
                user.getCity(),
                user.getState(),
                user.getPincode(),
                authority
        );
    	
    }
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(authority);
		return authorities;
	}

	public GrantedAuthority getAuthority() {
        return authority;
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

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
