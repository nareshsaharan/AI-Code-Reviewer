package com.acciojob.aicodereview.service;

import com.acciojob.aicodereview.model.CodeSubmission;
import com.acciojob.aicodereview.repository.CodeSubmissionReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {

    @Autowired
    private CodeSubmissionReporsitory submissionReporsitory;

    public CodeSubmission createSubmission(CodeSubmission submission) {

        CodeSubmission saved = submissionReporsitory.save(submission);

        return saved;

    }
}
