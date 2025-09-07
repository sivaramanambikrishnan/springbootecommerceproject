package com.projectexample.ecommercedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectexample.ecommercedemo.entity.SigninEntity;

import jakarta.persistence.Id;

@Repository
public interface SigninRepository extends JpaRepository<SigninEntity,Id> {
	  SigninEntity findByEmail(String email);
	  
   
}
