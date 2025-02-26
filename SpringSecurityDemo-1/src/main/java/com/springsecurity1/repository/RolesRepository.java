package com.springsecurity1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity1.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles,Long> {

}
