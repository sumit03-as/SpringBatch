package com.springBatch.config;

import com.springBatch.entity.TestCases;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomItemProcessor implements ItemProcessor<TestCases, TestCases> {
    @Override
    public TestCases process(TestCases testCases) throws Exception {
        return null;
    }
}
