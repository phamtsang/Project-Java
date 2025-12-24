package com.example.demo.api.controller;

import com.example.demo.application.service.AdminService;
import com.example.demo.domain.entity.SubscriptionPlan;
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

    // API tạo gói dịch vụ
    @PostMapping("/plans")
    public ResponseEntity<SubscriptionPlan> createPlan(@RequestBody SubscriptionPlan plan) {
        return ResponseEntity.ok(adminService.createSubscriptionPlan(plan));
    }

    // API tạo tài khoản Owner mới
    // Request Body nên dùng DTO, ở đây dùng tạm User để demo nhanh
    @PostMapping("/owners")
    public ResponseEntity<User> createOwner(@RequestParam String phone,
                                            @RequestParam String name,
                                            @RequestParam String password,
                                            @RequestParam String storeName, // Thêm tham số này
                                            @RequestParam Long planId) {
        return ResponseEntity.ok(adminService.registerOwner(phone, name, password, storeName, planId));
    }

    // API xem danh sách Owner
    @GetMapping("/owners")
    public ResponseEntity<List<User>> getAllOwners() {
        return ResponseEntity.ok(adminService.getAllOwners());
    }

    // API Dashboard tổng quan
    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboard() {
        return ResponseEntity.ok(adminService.getSystemOverview());
    }
}