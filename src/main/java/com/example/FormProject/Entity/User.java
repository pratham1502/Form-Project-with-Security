package com.example.FormProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String username;
		private String password;
		private String fullname;
		
		public User() {
			
		}
		
		public User(String username, String password, String fullname) {
			  super();
			  this.username = username;
			  this.password = password;
			  this.fullname = fullname;
			 }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getusername() {
			return username;
		}

		public void setusername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		@Override
		 public String toString() {
		  return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname + "]";
		 }

}
