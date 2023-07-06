package com.example.StudentRegisteration.security;

import com.example.StudentRegisteration.dao.StudentDao;
import com.example.StudentRegisteration.ds.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student=studentDao.findStudentByStudentName(username);
        if(student==null){
            throw new UsernameNotFoundException("User Not Found");
        }
      
        return new CustomUserDetail(student);
    }
}
