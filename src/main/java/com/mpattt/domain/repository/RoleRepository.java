package com.mpattt.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpattt.domain.entity.UserRole;

@Repository
public interface RoleRepository  extends JpaRepository<UserRole, Integer> {

}
