package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.service.AdminService;
import com.example.demo.domain.entity.SubscriptionPlan;
import com.example.demo.domain.entity.SystemConfig;
import com.example.demo.domain.entity.SystemNotification;
import com.example.demo.domain.entity.User;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // ==========================================
    //      QUẢN LÝ GÓI DỊCH VỤ (SUBSCRIPTION)
    // ==========================================

    // Tạo gói mới
    @PostMapping("/plans")
    public ResponseEntity<SubscriptionPlan> createPlan(@RequestBody SubscriptionPlan plan) {
        return ResponseEntity.ok(adminService.createPlan(plan));
    }

    // Xem danh sách gói
    @GetMapping("/plans")
    public ResponseEntity<List<SubscriptionPlan>> getAllPlans() {
        return ResponseEntity.ok(adminService.getAllPlans());
    }

    // Cập nhật gói
    @PutMapping("/plans/{id}")
    public ResponseEntity<SubscriptionPlan> updatePlan(@PathVariable Long id, @RequestBody SubscriptionPlan plan) {
        return ResponseEntity.ok(adminService.updatePlan(id, plan));
    }

    // Xóa gói
    @DeleteMapping("/plans/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        adminService.deletePlan(id);
        return ResponseEntity.ok("Đã xóa Gói dịch vụ thành công");
    }

    // ==========================================
    //  QUẢN LÝ TÀI KHOẢN OWNER (CHỦ SHOP)
    // ==========================================

    // Đăng ký Owner mới (kèm tạo Store)
    @PostMapping("/owners")
    public ResponseEntity<User> createOwner(@RequestParam String phone,
                                            @RequestParam String name,
                                            @RequestParam String password,
                                            @RequestParam String storeName,
                                            @RequestParam Long planId) {
        return ResponseEntity.ok(adminService.registerOwner(phone, name, password, storeName, planId));
    }

    // Xem danh sách Owner
    @GetMapping("/owners")
    public ResponseEntity<List<User>> getAllOwners() {
    return ResponseEntity.ok(adminService.getAllOwners());
    }

    // Khóa/Mở khóa Owner
    @PutMapping("/owners/{id}/status")
    public ResponseEntity<User> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(adminService.updateOwnerStatus(id, status));
    }

    // Xóa Owner
    @DeleteMapping("/owners/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        adminService.deleteOwner(id);
        return ResponseEntity.ok("Đã xóa Owner và Cửa hàng thành công");
    }


    // ==========================================
    //  QUẢN LÝ CẤU HÌNH & TEMPLATE BÁO CÁO
    // ==========================================

    // Lưu cấu hình hoặc Template báo cáo
    @PostMapping("/configs")
    public ResponseEntity<SystemConfig> saveConfig(@RequestBody SystemConfig config) {
        return ResponseEntity.ok(adminService.saveConfig(config));
    }

    // Xem danh sách cấu hình
    @GetMapping("/configs")
    public ResponseEntity<List<SystemConfig>> getConfigs() {
        return ResponseEntity.ok(adminService.getAllConfigs());
    }

    // ==========================================
    //      GỬI THÔNG BÁO TOÀN HỆ THỐNG
    // ==========================================

    @PostMapping("/notifications")
    public ResponseEntity<SystemNotification> sendNotification(@RequestParam String title,
                                                               @RequestParam String message) {
        return ResponseEntity.ok(adminService.createBroadcastNotification(title, message));
    }

    // ==========================================
    // 5. BÁO CÁO TỔNG QUAN (DASHBOARD)
    // ==========================================

    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboard() {
        return ResponseEntity.ok(adminService.getSystemOverview());
    }
}