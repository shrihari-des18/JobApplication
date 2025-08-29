package com.shrihari.jobapplication.repo;

import com.shrihari.jobapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
