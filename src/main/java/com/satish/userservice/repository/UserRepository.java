package com.satish.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satish.userservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
