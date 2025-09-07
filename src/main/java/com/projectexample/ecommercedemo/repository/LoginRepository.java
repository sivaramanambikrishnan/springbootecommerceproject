package com.projectexample.ecommercedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.projectexample.ecommercedemo.entity.LoginEntity;

import jakarta.persistence.Id;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Id>{
	

}
