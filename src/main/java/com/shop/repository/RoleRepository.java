package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entities.UserRole;

public interface RoleRepository extends JpaRepository<UserRole, Integer>
{
   
 
}

