package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Role;
import com.app.entity.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRoleName(RoleName roleName);
}
