package com.EShopAlBe.EShop.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EShopAlBe.EShop.auth.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    public User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    Optional <User> findByCliente(String cliente);
}
