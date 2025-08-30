package com.shrihari.jobapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPost {
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private String location;
    private String companyName;
    private Double salary;
    private enum jobType {FULL_TIME, PART_TIME, CONTRACT, INTERN}
    private String postDate;
    private List<String> postTechStack;

}
