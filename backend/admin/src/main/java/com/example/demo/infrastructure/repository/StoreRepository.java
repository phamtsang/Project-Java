package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    boolean existsBySubscriptionPlanId(Long id);
}