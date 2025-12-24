package com.example.demo.api.controller;

import com.example.demo.application.service.AdminService;
import com.example.demo.domain.entity.SubscriptionPlan;
import com.example.demo.domain.entity.SystemConfig;
import com.example.demo.domain.entity.SystemNotification;
import com.example.demo.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Cập nhật gói (Mới thêm)
    @PutMapping("/plans/{id}")
    public ResponseEntity<SubscriptionPlan> updatePlan(@PathVariable Long id, @RequestBody SubscriptionPlan plan) {
        return ResponseEntity.ok(adminService.updatePlan(id, plan));
    }

    // Xóa gói (Mới thêm)
    @DeleteMapping("/plans/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        adminService.deletePlan(id);
        return ResponseEntity.ok("Đã xóa Gói dịch vụ thành công");
    }
}