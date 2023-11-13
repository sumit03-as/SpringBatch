package com.springBatch.repository;

import com.springBatch.entity.TestCases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<TestCases, Long> {
}
