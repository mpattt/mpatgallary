package com.mpattt.domain.service;

import com.mpattt.domain.entity.User;

public interface UserAccountService {
	User findOneByEmail(String username);
}
