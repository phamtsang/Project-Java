package com.example.demo.application.service;

import com.example.demo.domain.entity.*;
import com.example.demo.infrastructure.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

    @Autowired private SubscriptionPlanRepository planRepository;

    // --- QUẢN LÝ GÓI DỊCH VỤ (Subscription) ---

    public SubscriptionPlan createPlan(SubscriptionPlan plan) { return planRepository.save(plan); }
    public List<SubscriptionPlan> getAllPlans() { return planRepository.findAll(); }

    // Sửa gói
    public SubscriptionPlan updatePlan(Long id, SubscriptionPlan input) {
        SubscriptionPlan plan = planRepository.findById(id).orElseThrow();
        plan.setName(input.getName());
        plan.setPrice(input.getPrice());
        plan.setDescription(input.getDescription());
        return planRepository.save(plan);
    }

    // XÓA Gói
    public void deletePlan(Long id) {
        // Kiểm tra xem có cửa hàng nào đang dùng gói này không trước khi xóa
        if (storeRepository.existsBySubscriptionPlanId(id)) { // Cần thêm hàm này trong Repo
            throw new RuntimeException("Không thể xóa gói đang có người sử dụng!");
        }
        planRepository.deleteById(id);
    }
}