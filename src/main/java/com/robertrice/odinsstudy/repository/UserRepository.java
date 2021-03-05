package com.robertrice.odinsstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertrice.odinsstudy.models.User;

//sets up queries to the data base for User entities
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
