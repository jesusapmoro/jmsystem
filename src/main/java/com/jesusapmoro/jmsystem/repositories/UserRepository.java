package com.jesusapmoro.jmsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesusapmoro.jmsystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
