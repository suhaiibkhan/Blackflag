package com.BlackFlag.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BlackFlag.project.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}