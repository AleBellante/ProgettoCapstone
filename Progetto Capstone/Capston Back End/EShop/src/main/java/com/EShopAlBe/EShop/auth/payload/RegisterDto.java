package com.EShopAlBe.EShop.auth.payload;

import java.util.Set;

import com.EShopAlBe.EShop.functions.model.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
    private Client cliente;
    
}
