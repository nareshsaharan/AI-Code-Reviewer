package com.acciojob.aicodereview.service;

import com.acciojob.aicodereview.model.CodeSubmission;
import com.acciojob.aicodereview.model.CodeVersion;
import com.acciojob.aicodereview.repository.CodeSubmissionReporsitory;
import com.acciojob.aicodereview.repository.CodeVersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CodeService {

    @Autowired
    private CodeSubmissionReporsitory submissionReporsitory;

    @Autowired
    private CodeVersonRepository versionRepository;

    public CodeSubmission createSubmission(CodeSubmission submission) {

        CodeSubmission saved = submissionReporsitory.save(submission);

        // create inital version
        CodeVersion version = new CodeVersion();
        version.setSubmission(saved);
        version.setVersionNumber(1);
        version.setCode(submission.getCode());
        version.setAnalysis("Pending analysis...");
        versionRepository.save(version);

        return saved;

    }

    public List<CodeSubmission> getUserSubmissions(UUID userId) {
        return submissionReporsitory.findByUserId(userId);
    }
}
