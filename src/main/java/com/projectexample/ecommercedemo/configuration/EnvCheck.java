package com.projectexample.ecommercedemo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnvCheck implements CommandLineRunner {

    @Value("${spring.datasource.url:NOT_SET}")
    private String url;

    @Value("${spring.datasource.username:NOT_SET}")
    private String user;

    @Override
    public void run(String... args) {
        System.out.println(">>> DB URL: " + url);
        System.out.println(">>> DB USER: " + user);
    }
}