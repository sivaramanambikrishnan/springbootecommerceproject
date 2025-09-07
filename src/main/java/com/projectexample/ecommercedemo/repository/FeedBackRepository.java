package com.projectexample.ecommercedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectexample.ecommercedemo.entity.FeedbackEntity;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedbackEntity, Long> {
    List<FeedbackEntity> findByProductId(String productId);
}