package com.EShopAlBe.EShop.auth.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.EShopAlBe.EShop.auth.payload.AdminRegister;
import com.EShopAlBe.EShop.auth.payload.LoginDto;
import com.EShopAlBe.EShop.auth.payload.RegisterDto;
import com.EShopAlBe.EShop.auth.repository.RoleRepository;
import com.EShopAlBe.EShop.auth.repository.UserRepository;
import com.EShopAlBe.EShop.auth.security.JwtTokenProvider;
import com.EShopAlBe.EShop.functions.service.ClientService;
import com.EShopAlBe.EShop.auth.entity.*;
import com.EShopAlBe.EShop.auth.exception.MyAPIException;



@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private ClientService cService;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        
    	Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(
        				loginDto.getUsername(), loginDto.getPassword()
        		)
        ); 
    	
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
		/*
		 * if(userRepository.existsByEmail(registerDto.getEmail())){ throw new
		 * MyAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!."); }
		 */
        
        User user = new User();
        user.setNome(registerDto.getNome());
        user.setCognome(registerDto.getCognome());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setCliente(registerDto.getCliente());
        
        Set<Role> roles = new HashSet<>();
        if(registerDto.getRoles() != null) {
	        registerDto.getRoles().forEach(role -> {
	        	Role userRole = roleRepository.findByRoleName(getRole(role)).get();
	        	roles.add(userRole);
	        });
        } else {
        	Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER).get();
        	roles.add(userRole);
        }
        
        
        user.setRoles(roles);
        System.out.println(user);
        userRepository.save(user);
        cService.saveClient(registerDto.getCliente());

        return "User and client registered successfully!.";
    }
    @Override
    public String adminRegister(AdminRegister adminRegister) {

        // add check for username exists in database
        if(userRepository.existsByUsername(adminRegister.getUsername())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
		/*
		 * if(userRepository.existsByEmail(registerDto.getEmail())){ throw new
		 * MyAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!."); }
		 */
        
        User user = new User();
        user.setNome(adminRegister.getNome());
        user.setCognome(adminRegister.getCognome());
        user.setUsername(adminRegister.getUsername());
        user.setEmail(adminRegister.getEmail());
        user.setPassword(passwordEncoder.encode(adminRegister.getPassword()));
        
        Set<Role> roles = new HashSet<>();
        if(adminRegister.getRoles() != null) {
        	adminRegister.getRoles().forEach(role -> {
	        	Role userRole = roleRepository.findByRoleName(getRole(role)).get();
	        	roles.add(userRole);
	        });
        } else {
        	Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER).get();
        	roles.add(userRole);
        }
        
        
        user.setRoles(roles);
        System.out.println(user);
        userRepository.save(user);

        return "User registered successfully!.";
    }
    
    public ERole getRole(String role) {
    	if(role.equals("ROLE_ADMIN")) return ERole.ROLE_ADMIN;
    	else return ERole.ROLE_USER;
    }
    public Set<Role> findRolesByUsername(String username ) {
    	Set<Role> roles = new HashSet<>();
    	User u = userRepository.findByUsername(username);
    	roles = u.getRoles();
    	return roles;
    }
    
    
    
}
