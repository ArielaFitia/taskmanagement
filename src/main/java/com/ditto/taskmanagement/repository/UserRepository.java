package com.ditto.taskmanagement.repository;

import com.ditto.taskmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
