package com.EShopAlBe.EShop.auth.payload;

import java.util.Set;

import com.EShopAlBe.EShop.auth.entity.ERole;
import com.EShopAlBe.EShop.auth.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	private String username;
    private String accessToken;
    private String tokenType = "Bearer";
    private Set<Role>roles ;
}
