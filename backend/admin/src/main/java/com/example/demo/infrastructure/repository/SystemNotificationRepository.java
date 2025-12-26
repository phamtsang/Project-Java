package com.example.demo.infrastructure.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.entity.SystemNotification;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SystemNotificationRepository extends JpaRepository<SystemNotification, Long>{
}