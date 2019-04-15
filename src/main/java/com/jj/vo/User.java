package com.jj.vo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int no;
	@Column(name = "user_id", nullable = false)
	private String id;
	@Column(name = "user_password", nullable = false)
	private String password;
	@Column(name = "user_email", nullable = false)
	private String email;
	@Column(name = "user_name", nullable = false)
	private String name;
	@Column(name = "user_create_date")
	@CreationTimestamp
	private LocalDate createDate;
	@Column(name = "user_auth_status")
	private int authStatus = 1;
	
	public User() {
		
	}

	public User(String id, String password, String email, String name) {
		this.id 	  = id;
		this.password = password;
		this.email 	  = email;
		this.name 	  = name;
	}

	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public int getUserAuthStatus() {
		return authStatus;
	}

	public void setUserAuthStatus(int authStatus) {
		this.authStatus = authStatus;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", id=" + id + ", password=" + password + ", email=" + email + ", name=" + name
				+ ", createDate=" + createDate + ", authStatus=" + authStatus + "]";
	}
}
