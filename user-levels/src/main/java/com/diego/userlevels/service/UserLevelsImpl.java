package com.diego.userlevels.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diego.userlevels.entity.UserLevels;
import com.diego.userlevels.repository.UserLevelsRepo;

@Service
public class UserLevelsImpl implements UserLevelsService{

	@Autowired
	private UserLevelsRepo userlevelsrepo;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<UserLevels> findAll() {
		return userlevelsrepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<UserLevels> findAll(Pageable pageable) {
		return userlevelsrepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<UserLevels> findById(Long id) {
		return userlevelsrepo.findById(id);
	}

	@Override
	@Transactional
	public UserLevels save(UserLevels userlevels) {
		return userlevelsrepo.save(userlevels);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userlevelsrepo.deleteById(id);
	}
}
