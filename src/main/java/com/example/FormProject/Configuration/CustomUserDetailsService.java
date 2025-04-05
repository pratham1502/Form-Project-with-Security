package com.example.FormProject.Configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.FormProject.Entity.User;
import com.example.FormProject.Repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService  {
    
//	@Autowired
//    public static final UserRepository userRepository = null;

	@Autowired
	private final UserRepository userRepository;
	
	
	@Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username or password not found");
        }
        // Return the CustomUserDetails object
        return new CustomUserDetails(user.getusername(), user.getPassword(), authorities(), user.getFullname());
    }

    private Collection<? extends GrantedAuthority> authorities() {
        // Example of granting authorities, you might need to adjust this depending on your User model
        return List.of(() -> "ROLE_USER"); // Here assuming every user has "ROLE_USER"
    }
}
