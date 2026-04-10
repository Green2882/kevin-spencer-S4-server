package com.keyin.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRestRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
