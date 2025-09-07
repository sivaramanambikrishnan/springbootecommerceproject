package com.projectexample.ecommercedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectexample.ecommercedemo.entity.SigninEntity;
import com.projectexample.ecommercedemo.filters.JwtUtil;
import com.projectexample.ecommercedemo.repository.SigninRepository;


@RestController

@CrossOrigin(origins = "http://localhost:5173")
public class SigninController {
    
    @Autowired
    private SigninRepository users;
    
    @Autowired
    private SigninRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserDetailsService userDetailsService;


    @PostMapping("/api/signup")
    public ResponseEntity<?> register(@RequestBody SigninEntity request) {
        if (users.findByEmail(request.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }

        SigninEntity user = new SigninEntity();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        users.save(user);

        String token = jwtUtil.generateToken(user.getEmail());
        System.out.println("JWT Token: " + token);
        return ResponseEntity.status(HttpStatus.CREATED).body("Signup successful");
    }
    
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {	
    	System.out.println("Login attempt: " + authRequest.getEmail() + " / " + authRequest.getPassword());
    	 
    	 try {
             authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
             );
         } catch (BadCredentialsException e) {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
         }

         UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
         String token = jwtUtil.generateToken(userDetails.getUsername());
         return ResponseEntity.ok(new AuthResponse(token));
     }
    
}