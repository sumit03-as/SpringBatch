package com.springBatch.service;

import org.springframework.web.multipart.MultipartFile;

public interface TestCaseService {
    void processCSV(MultipartFile file) throws Exception;
}
