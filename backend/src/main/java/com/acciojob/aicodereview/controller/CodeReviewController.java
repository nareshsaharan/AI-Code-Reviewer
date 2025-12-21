package com.acciojob.aicodereview.controller;

import com.acciojob.aicodereview.model.CodeSubmission;
import com.acciojob.aicodereview.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
public class CodeReviewController {

    @Autowired
    private CodeService codeService;

    @GetMapping("/hello")
    public String sayHello() {
        return "hey this is backend code";
    }

    @PostMapping("/upload")
    public ResponseEntity<CodeSubmission> uploadCode(@RequestBody CodeSubmission submission) {
        return ResponseEntity.ok(codeService.createSubmission(submission));
    }

}
