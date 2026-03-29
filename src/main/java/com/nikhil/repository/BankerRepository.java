package com.nikhil.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.entity.Banker;

public interface BankerRepository extends JpaRepository<Banker, Long> {
	 Optional<Banker> findByUsername(String username);}