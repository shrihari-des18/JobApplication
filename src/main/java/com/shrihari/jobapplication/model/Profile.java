package com.shrihari.jobapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {
    @Id
    private Long id;
    @OneToOne
    private User user;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String skills; // Comma-separated skills
    private String experience; // Comma-separated experiences
    private String education; // Comma-separated education details
    private String resumeLink; // Link to the resume


}
