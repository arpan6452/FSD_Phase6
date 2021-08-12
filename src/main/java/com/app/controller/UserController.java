package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.BadRoleException.BadRoleException;
import com.app.dto.AuthRequest;
import com.app.dto.LoginResponseVO;
import com.app.dto.RegistrationRequest;
import com.app.dto.RegistrationResponseVO;
import com.app.dto.UpdatePasswordResponse;
import com.app.dto.UpdatePasswordVO;
import com.app.entity.Role;
import com.app.entity.RoleName;
import com.app.entity.User;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;
import com.app.service.AdminUserService;
import com.app.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins= {"http://localhost:8989", "http://localhost:9876"})
@Api(value="User Controller", description="This is a User Controller API, you can register and login as an admin/password.")
public class UserController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManger;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private AdminUserService adminUserService;
	
	@GetMapping("/all")
	public String welcomeApp() {
		return "Welcome to the Application";
	}
	
	@ApiOperation("User can login into the application entering their username and password")
	@PostMapping("/login")
	public LoginResponseVO login(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			Authentication authentication = authenticationManger.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
			);
			String data = jwtUtil.generateToken(authRequest.getUsername());
			
			return new LoginResponseVO(data, authRequest.getUsername(), authentication.getAuthorities().iterator().next().toString(), 2000);
		}catch (Exception e) {
			throw new Exception("Invalid Username and Password");
		}
	}
	
	@ApiOperation("User can register themselves into the application as an admin or user.")
	@PostMapping("/registration")
	public RegistrationResponseVO registration(@RequestBody RegistrationRequest registrationRequest) throws BadRoleException {
		if (userRepository.existsByUsername(registrationRequest.getUsername())) {
			return new RegistrationResponseVO(registrationRequest.getUsername(), "EmailId already exist");
		}
		
		Role role = null;
		if(registrationRequest.getRoleName().toLowerCase().equals("admin")) {
			role = roleRepository.findByRoleName(RoleName.ROLE_ADMIN);
			roleRepository.save(role);
		}
		else if(registrationRequest.getRoleName().toLowerCase().equals("user")) {
			role = roleRepository.findByRoleName(RoleName.ROLE_USER);
			roleRepository.save(role);
		}
		else
			throw new BadRoleException("Bad Role Exception. Please choose role in {} {} " + RoleName.ROLE_ADMIN +RoleName.ROLE_USER);
		
		
		User user = new User( role, registrationRequest.getUsername(), passwordEncoder.encode(registrationRequest.getPassword()), 
				registrationRequest.getAddress1(), registrationRequest.getAddress2(), registrationRequest.getCity(), 
				registrationRequest.getState(), registrationRequest.getPincode());
		userRepository.save(user);
		return new RegistrationResponseVO(registrationRequest.getUsername(), "User Registered successfully");

	}
	
	@ApiOperation("User cwith admin access can update their password")
	@PutMapping("/updatePassword")
	public UpdatePasswordResponse changePassword(@RequestBody UpdatePasswordVO updatePasswordVO) {//(@RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword") String newpassword,
			//@RequestParam("username") String username) {
		return new UpdatePasswordResponse(adminUserService.changePassword(updatePasswordVO.getOldpassword(), updatePasswordVO.getNewpassword(), updatePasswordVO.getUsername()));
	}
	

}
