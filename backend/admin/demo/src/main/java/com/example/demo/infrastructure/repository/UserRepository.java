package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Tìm kiếm Owner để quản lý
    List<User> findByRole(Role role);
    boolean existsByUsername(String username);
}