package com.projectexample.ecommercedemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectexample.ecommercedemo.entity.GoogleOauthLoginEntity;

public interface GoogleOauthLoginRepository extends JpaRepository<GoogleOauthLoginEntity,Long>{
	 Optional <GoogleOauthLoginEntity> findByEmail(String email);
}
