package com.mpattt.domain.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mpattt.app.user.UserRegisterForm;
import com.mpattt.domain.component.PasswordEncoder;
import com.mpattt.domain.entity.User;
import com.mpattt.domain.entity.UserRole;
import com.mpattt.domain.repository.RoleRepository;
import com.mpattt.domain.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;


	public void createUser(UserRegisterForm userAddForm) throws NoSuchAlgorithmException {
		//Date nowDate = Calendar.getInstance().getTime();
		User user = new User();
		UserRole role = new UserRole();
		user.setName(userAddForm.getName());
		user.setEmail(userAddForm.getEmail());
		user.setPassword(passwordEncoder.hashMD5(userAddForm.getPassword()));
		
		//user.setCreated(nowDate);
		//user.setUpdated(nowDate);
		userRepository.save(user);
		User finduser = userRepository.findOneByEmail(user.getEmail());
		role.setId(finduser.getId());
		role.setRole(1);
		roleRepository.save(role);
		
	}

	public Page<User> findAllUser(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public User findOne(int userId) {
		return userRepository.findOne(userId);
	}

	/*public UserEditForm setUserEditForm(int userId) {
		User user = userRepository.findOne(userId);
		UserEditForm userEditForm = new UserEditForm();
		userEditForm.setUserId(user.getId());
		userEditForm.setName(user.getName());
		userEditForm.setEmail(user.getEmail());
		return userEditForm;
	}

	public void updateUser(UserEditForm userEditForm) throws NoSuchAlgorithmException {
		Date nowDate = Calendar.getInstance().getTime();
		User user = userRepository.findOne(userEditForm.getUserId());
		user.setName(userEditForm.getName());
		user.setPassword(passwordEncoder.hashMD5(userEditForm.getPassword()));
		user.setUpdated(nowDate);
		userRepository.save(user);
	}

	public void deleteUser(int userId) {
		userRepository.delete(userId);
	}*/
	
	public Page<User> getAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
}
