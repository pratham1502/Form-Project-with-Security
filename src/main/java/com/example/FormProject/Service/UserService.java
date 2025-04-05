package com.example.FormProject.Service;

import org.springframework.stereotype.Service;

import com.example.FormProject.Entity.User;
import com.example.FormProject.dto.UserDto;

@Service
public interface UserService {
	
	User findByUsername(String username);
	
	User save(UserDto userDto);
	
	

}
