package com.mms.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.auth.model.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public Optional<UserEntity> findByUsername(String username);
}
