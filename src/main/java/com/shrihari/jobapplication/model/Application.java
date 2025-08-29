package com.shrihari.jobapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Application {
    @Id
    private int applicationId;
    @ManyToOne
    private JobPost jobPost;
    @ManyToOne
    private User candidate;
    private enum status {APPLIED, UNDER_REVIEW, INTERVIEW_SCHEDULED, REJECTED, OFFERED, HIRED}
    private String applicationDate;
}
