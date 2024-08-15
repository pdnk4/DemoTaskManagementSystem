package com.example.testtaskmanagementsystem.repository;

import com.example.testtaskmanagementsystem.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
