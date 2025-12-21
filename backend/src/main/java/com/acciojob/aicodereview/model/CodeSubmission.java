package com.acciojob.aicodereview.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "code_submission")
public class CodeSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    private String filename;
    private String language;

    @Column(columnDefinition = "TEXT")
    private String code;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
