package com.springBatch.entity;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(
        name = "testCases"
)
public class TestCases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String testCaseId;
    private String result;
    private String feedback;
}
