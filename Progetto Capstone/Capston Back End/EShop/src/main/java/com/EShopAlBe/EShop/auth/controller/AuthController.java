package com.EShopAlBe.EShop.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.EShopAlBe.EShop.auth.payload.AdminRegister;
import com.EShopAlBe.EShop.auth.payload.JWTAuthResponse;
import com.EShopAlBe.EShop.auth.payload.LoginDto;
import com.EShopAlBe.EShop.auth.payload.RegisterDto;
import com.EShopAlBe.EShop.auth.service.AuthService;
import com.EShopAlBe.EShop.auth.service.AuthServiceImpl;
import com.EShopAlBe.EShop.functions.service.ClientService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    
    
    @Autowired
    private AuthServiceImpl getRolesRepo;
 

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
           	
    	String token = authService.login(loginDto);
    	
    	
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUsername(loginDto.getUsername());
        
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setRoles(getRolesRepo.findRolesByUsername(loginDto.getUsername()));
        return ResponseEntity.ok(jwtAuthResponse);
        
    }

    // Build Register REST API

    @CrossOrigin(origins = "*")
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto) ;
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @PostMapping(value = {"/register/admin", "/signup/admin"})
    public ResponseEntity<String> adminRegister(@RequestBody AdminRegister adminregister){
        String response = authService.adminRegister(adminregister);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
