package com.projectexample.ecommercedemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Login")
public class LoginEntity {
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private long id;
      private String email;
      public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public LoginEntity(long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	private String password;
}
