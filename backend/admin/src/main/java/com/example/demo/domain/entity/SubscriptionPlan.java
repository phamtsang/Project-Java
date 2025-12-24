package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "subscription_plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Ví dụ: "Gói Cơ Bản", "Gói Nâng Cao"
    private BigDecimal price;
    private String description;

    // Giới hạn tính năng (ví dụ: số lượng đơn hàng/tháng)
    private int maxOrdersPerMonth;
}