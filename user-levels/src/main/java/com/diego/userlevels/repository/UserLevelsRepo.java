package com.diego.userlevels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.userlevels.entity.UserLevels;

@Repository
public interface UserLevelsRepo extends JpaRepository<UserLevels,Long> {

}
