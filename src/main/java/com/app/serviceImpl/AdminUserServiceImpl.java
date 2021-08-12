package com.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entity.Item;
import com.app.entity.User;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;
import com.app.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public String changePassword(String oldpassword, String newpassword, String username) {
		User updatedUser = userRepository.findByusername(username);
		try {
			if(passwordEncoder.matches(oldpassword, updatedUser.getPassword())) {
				updatedUser.setPassword(passwordEncoder.encode(newpassword));
				userRepository.save(updatedUser);
				return "Password updated successfully";
			}else {
				return "Incorrect/Invalid old password";
			}
		}catch (Exception e) {
			return "Incorrect/Invalid old password";
		}
		
	}

}
