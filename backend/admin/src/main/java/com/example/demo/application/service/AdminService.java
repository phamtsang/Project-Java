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

    // --- 1. QUẢN LÝ GÓI DỊCH VỤ (Subscription) ---

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

    // --- 2. QUẢN LÝ TÀI KHOẢN OWNER (Full CRUD) ---

    // Tạo (Đã có)
    @Transactional
    public User registerOwner(String phone, String fullName, String rawPassword, String storeName, Long planId) {
        if (userRepository.existsByUsername(phone)) throw new RuntimeException("SĐT đã tồn tại");
        SubscriptionPlan plan = planRepository.findById(planId).orElseThrow(() -> new RuntimeException("Gói không tồn tại"));

        Store newStore = Store.builder().name(storeName).subscriptionPlan(plan).status("ACTIVE").build();
        newStore = storeRepository.save(newStore);

        User owner = User.builder().username(phone).password(rawPassword).fullName(fullName)
                .role(Role.OWNER).store(newStore).status("ACTIVE").build();
        return userRepository.save(owner);
    }

    // Xem danh sách
    public List<User> getAllOwners() { return userRepository.findByRole(Role.OWNER); }

    // Sửa trạng thái (Khóa/Mở)
    public User updateOwnerStatus(Long userId, String status) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setStatus(status);
        return userRepository.save(user);
    }

    // XÓA Owner (Cẩn trọng: Xóa cả User lẫn Store)
    @Transactional
    public void deleteOwner(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User không tồn tại"));
        Store store = user.getStore();

        // Xóa User trước
        userRepository.delete(user);

        // Nếu Store không còn ai quản lý thì xóa luôn Store (Tùy logic nghiệp vụ)
        if (store != null) {
            storeRepository.delete(store);
        }
    }