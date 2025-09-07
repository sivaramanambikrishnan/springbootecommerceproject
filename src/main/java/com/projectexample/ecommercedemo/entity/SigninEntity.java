package com.projectexample.ecommercedemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class SigninEntity {
          @Id
          @GeneratedValue(strategy=GenerationType.IDENTITY)
          private Long id;
          private String email;
          private String password;
          private String username;
		public SigninEntity() {
			super();
		}
		public SigninEntity(Long id, String email, String password, String username) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
			this.username = username;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
          
}
