package com.springBatch.controller;

import com.springBatch.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/csv")
public class TestCaseController {

    @Autowired
    private TestCaseService csvService;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // Pass the uploaded file to the service layer for processing
            csvService.processCSV(file);
            return new ResponseEntity<>("File uploaded and processing started successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing the CSV file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
