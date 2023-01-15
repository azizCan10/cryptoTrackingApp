package com.test.cryptotrackapp.repository;

import com.test.cryptotrackapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getByUsernameAndPassword(String username, String password);
}
