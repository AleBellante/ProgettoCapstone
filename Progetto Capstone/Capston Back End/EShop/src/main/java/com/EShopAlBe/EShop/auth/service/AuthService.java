package com.EShopAlBe.EShop.auth.service;

import com.EShopAlBe.EShop.auth.payload.AdminRegister;
import com.EShopAlBe.EShop.auth.payload.LoginDto;
import com.EShopAlBe.EShop.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    String adminRegister(AdminRegister adminregister);
    
}
