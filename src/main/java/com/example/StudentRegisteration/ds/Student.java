package com.example.StudentRegisteration.ds;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity

public class Student {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", nrc=" + nrc + ", phoneNumber=" + phoneNumber + ", password="
				+ password + ", role=" + role + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String nrc;
	private String phoneNumber;
	private String password;
	private String role;


	
	

}
