package com.acciojob.aicodereview.controller;

import com.acciojob.aicodereview.model.CodeSubmission;
import com.acciojob.aicodereview.model.CodeVersion;
import com.acciojob.aicodereview.service.CodeService;
import com.acciojob.aicodereview.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/code")
public class CodeReviewController {

    @Autowired
    private CodeService codeService;

    @Autowired
    private VersionService versionService;

    @GetMapping("/hello")
    public String sayHello() {
        return "hey this is backend code";
    }

    @PostMapping("/upload")
    public ResponseEntity<CodeSubmission> uploadCode(@RequestBody CodeSubmission submission) {
        return ResponseEntity.ok(codeService.createSubmission(submission));
    }

    @PostMapping("/analyze/{submissionId}")
    public ResponseEntity<CodeVersion> analyzedCode(@PathVariable UUID submissionId) {

        List<CodeVersion> submission = versionService.getVersion(submissionId);

        Optional<CodeVersion> latest = versionService.getVersion(submissionId).stream()
                    .max(Comparator.comparingInt(CodeVersion::getVersionNumber));

        if(latest.isPresent()) {
            return ResponseEntity.ok(versionService.analyzeVersion(latest.get().getId()));
        }

        return ResponseEntity.notFound().build();
    }
}
