package com.diego.userlevels.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diego.userlevels.entity.UserLevels;

public interface UserLevelsService {
	
	public Iterable<UserLevels> findAll();
	
	public Page<UserLevels> findAll(Pageable pageable);
	
	public Optional<UserLevels> findById(Long id);
	
	public UserLevels save(UserLevels userlevels);
	
	public void deleteById(Long id);

}
