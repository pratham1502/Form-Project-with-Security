package com.example.FormProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.FormProject.Entity.User;
import com.example.FormProject.Repositories.UserRepository;
import com.example.FormProject.dto.UserDto;

@Service
public class UserServiceImpl implements UserService  {
    
	@Autowired
	 UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;



    public User findByUsername(String username) {
		return userRepository.findByUsername(username);
    	
    }

//    public User save(UserDto userDto) {
//    	User user = new User();
//    	user.setFullname(userDto.getFullname());
//    	user.setPassword(userDto.getPassword());
//		return userRepository.save(user);
//    	
//    }
    
    public User save(UserDto userDto) {
        User user = new User();
        user.setusername(userDto.getUsername()); 
        user.setFullname(userDto.getFullname());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }
}
	