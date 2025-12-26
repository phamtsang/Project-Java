package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "system_configs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemConfig {
    @Id
    @Column(length = 50)
    private String configKey; // Ví dụ: "REPORT_TEMPLATE_01", "COMMISSION_RATE"

    @Column(columnDefinition = "TEXT")
    private String configValue; // Lưu nội dung HTML mẫu báo cáo hoặc giá trị cấu hình

    private String description; // Mô tả: "Mẫu báo cáo kết quả kinh doanh TT88"
}