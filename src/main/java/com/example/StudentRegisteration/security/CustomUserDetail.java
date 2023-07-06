package com.example.StudentRegisteration.security;

import com.example.StudentRegisteration.ds.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetail implements UserDetails {

	
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
    private Student student;
    
	

    public CustomUserDetail(Student student) {
    	
    	super();
        this.student = student;
    }
   
    


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(student.getRole()));
    }

    @Override
    public String getPassword() {
        
        return encoder.encode(student.getPassword());
    }

    @Override
    public String getUsername() {
        return student.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
