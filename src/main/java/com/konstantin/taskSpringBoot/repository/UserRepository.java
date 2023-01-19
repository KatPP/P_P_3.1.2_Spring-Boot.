package com.konstantin.taskSpringBoot.repository;

import com.konstantin.taskSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
