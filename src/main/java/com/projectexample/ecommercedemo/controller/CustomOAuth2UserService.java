package com.projectexample.ecommercedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import com.projectexample.ecommercedemo.entity.GoogleOauthLoginEntity;
import com.projectexample.ecommercedemo.repository.GoogleOauthLoginRepository;

@Component
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    private GoogleOauthLoginRepository signinRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = new DefaultOAuth2UserService().loadUser(userRequest);

        String email = oauth2User.getAttribute("email");
        String name = oauth2User.getAttribute("name");
        String picture = oauth2User.getAttribute("picture");

        signinRepository.findByEmail(email).orElseGet(() -> {
            GoogleOauthLoginEntity user = new GoogleOauthLoginEntity();
            user.setEmail(email);
            user.setName(name);
            user.setPicture(picture);
            return signinRepository.save(user);
        });

        return oauth2User;
    }
}
