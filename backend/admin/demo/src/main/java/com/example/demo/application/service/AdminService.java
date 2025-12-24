package com.example.demo.application.service;

import com.example.demo.domain.entity.*;
import com.example.demo.infrastructure.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreRepository storeRepository; // Mới thêm

    @Autowired
    private SubscriptionPlanRepository planRepository; // Mới thêm

    // 1. Tạo gói dịch vụ
    public SubscriptionPlan createSubscriptionPlan(SubscriptionPlan plan) {
        return planRepository.save(plan);
    }

    // 2. Đăng ký tài khoản cho Owner (Kèm tạo Store)
    @Transactional
    public User registerOwner(String phone, String fullName, String rawPassword, String storeName, Long planId) {
        // Kiểm tra trùng số điện thoại
        if (userRepository.existsByUsername(phone)) {
            throw new RuntimeException("Số điện thoại này đã được đăng ký!");
        }

        // Tìm gói dịch vụ
        SubscriptionPlan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Gói dịch vụ không tồn tại"));

        // Bước 1: Tạo Store trước
        Store newStore = Store.builder()
                .name(storeName)
                .subscriptionPlan(plan) // Gắn gói vào cửa hàng
                .status("ACTIVE")
                .build();

        newStore = storeRepository.save(newStore); // Lưu Store để có ID

        // Bước 2: Tạo User (Owner) và gắn vào Store vừa tạo
        User owner = User.builder()
                .username(phone)
                .password(rawPassword) // Lưu ý: Thực tế cần mã hóa BCrypt
                .fullName(fullName)
                .role(Role.OWNER)
                .store(newStore) // Gắn user vào store
                .status("ACTIVE")
                .build();

        return userRepository.save(owner);
    }

    // 3. Lấy danh sách Owner
    // Lưu ý: User entity mới đã đổi Role thành Enum, cần đảm bảo Repository tìm đúng
    public List<User> getAllOwners() {
        return userRepository.findByRole(Role.OWNER);
    }

    // 4. Lấy báo cáo toàn nền tảng
    public String getSystemOverview() {
        long totalOwners = userRepository.findByRole(Role.OWNER).size();
        long totalStores = storeRepository.count();
        return "Hệ thống BizFlow hiện có " + totalStores + " cửa hàng và " + totalOwners + " chủ hộ kinh doanh đang hoạt động.";
    }
}