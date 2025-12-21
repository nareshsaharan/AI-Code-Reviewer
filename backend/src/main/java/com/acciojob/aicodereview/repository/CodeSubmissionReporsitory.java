package com.acciojob.aicodereview.repository;

import com.acciojob.aicodereview.model.CodeSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CodeSubmissionReporsitory extends JpaRepository<CodeSubmission, UUID> {
    // select * from tableName where userId='x'
    List<CodeSubmission> findByUserId(UUID userId);
}
