package com.acciojob.aicodereview.service;

import com.acciojob.aicodereview.model.CodeVersion;
import com.acciojob.aicodereview.repository.CodeVersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VersionService {

    @Autowired
    private CodeVersonRepository versonRepository;

    @Autowired
    private AIService aiService;

    public List<CodeVersion> getVersion(UUID submissionId) {
        return versonRepository.findBySubmissionId(submissionId);
    }

    public CodeVersion analyzeVersion(UUID versionId) {
        CodeVersion version = versonRepository.findById(versionId)
                .orElseThrow(() -> new RuntimeException("version not found"));

        String analysis = aiService.analyzeCode(version.getCode());
        version.setAnalysis(analysis);
        return versonRepository.save(version);
    }

}
