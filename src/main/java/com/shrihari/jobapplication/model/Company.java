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
public class Company {
    @Id
    private int companyId;
    @OneToOne
    private User user;
    private String companyName;
    private String companyDescription;
    private String companyLocation;
    private String companyWebsite;
    private String companyContactEmail;
}
