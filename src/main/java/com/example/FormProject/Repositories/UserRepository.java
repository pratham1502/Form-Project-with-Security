package com.example.FormProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.FormProject.Entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
