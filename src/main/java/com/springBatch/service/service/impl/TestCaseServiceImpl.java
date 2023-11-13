package com.springBatch.service.service.impl;

import com.springBatch.service.TestCaseService;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    private static final Logger logger = LoggerFactory.getLogger(TestCaseServiceImpl.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job jobBean; // Assuming you have a Spring Batch job bean named 'csvJob'

    public void processCSV(MultipartFile file) throws Exception {
        try {
            // Pass the file to the Spring Batch job for processing
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("input.file.name", file.getOriginalFilename())
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

            JobExecution jobExecution = jobLauncher.run(jobBean, jobParameters);

            // Log the job execution status
            if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
                logger.info("Batch Job Completed Successfully");
            } else {
                logger.error("Batch Job Failed with status: {}", jobExecution.getStatus());
            }
        } catch (Exception e) {
            logger.error("Error processing the CSV file", e);
            throw e; // Rethrow the exception for better error handling
        }
    }
}

