package com.subrutin.lingkar.catalog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.lingkar.catalog.domain.User;

import jakarta.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);

}
