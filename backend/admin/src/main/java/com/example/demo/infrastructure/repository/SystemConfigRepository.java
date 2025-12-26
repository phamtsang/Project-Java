package com.example.demo.infrastructure.repository;


import org.springframework.stereotype.Repository;
import com.example.demo.domain.entity.SystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SystemConfigRepository extends JpaRepository<SystemConfig, String>{
}