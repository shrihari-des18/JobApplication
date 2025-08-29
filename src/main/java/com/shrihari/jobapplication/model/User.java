package com.shrihari.jobapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private enum role {ADMIN, USER, EMPLOYER}
}
