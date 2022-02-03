package com.study.structure.domain.pocketmark.repository;

import com.study.structure.domain.pocketmark.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
