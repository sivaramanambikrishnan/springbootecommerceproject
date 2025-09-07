package com.projectexample.ecommercedemo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectexample.ecommercedemo.entity.FeedbackEntity;
import com.projectexample.ecommercedemo.repository.FeedBackRepository;



@RestController
public class FeedbackController {

    @Autowired
    private FeedBackRepository feedbackRepository;

    @PostMapping("/feedback")
    public ResponseEntity<String> submitFeedback(@RequestBody FeedbackEntity feedback) {
        feedback.setCreatedAt(LocalDateTime.now());
        feedbackRepository.save(feedback);
        return ResponseEntity.ok("Feedback submitted");
    }

    @GetMapping("/feedback/{productId}")
    public List<FeedbackEntity> getFeedbackForProduct(@PathVariable String productId) {
        return feedbackRepository.findByProductId(productId);
    }
}