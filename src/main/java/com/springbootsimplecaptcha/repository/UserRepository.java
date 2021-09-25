package com.springbootsimplecaptcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsimplecaptcha.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
