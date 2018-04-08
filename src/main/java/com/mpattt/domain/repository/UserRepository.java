package com.mpattt.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpattt.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneByEmail(String email);

}
