package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Liên kết user với cửa hàng
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false) // Map với cột password_hash trong SQL
    private String password;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN, OWNER, EMPLOYEE

    @Column(length = 20)
    private String status; // ACTIVE, BLOCKED

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (status == null) status = "ACTIVE";
    }
}