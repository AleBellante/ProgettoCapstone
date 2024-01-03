package com.EShopAlBe.EShop.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EShopAlBe.EShop.auth.entity.ERole;
import com.EShopAlBe.EShop.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
