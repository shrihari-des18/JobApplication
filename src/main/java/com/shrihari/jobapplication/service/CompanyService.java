package com.shrihari.jobapplication.service;

import com.shrihari.jobapplication.model.Company;
import com.shrihari.jobapplication.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    public Company getCompany(Long companyId) {
        return companyRepo.findById(companyId).orElse(new Company());
    }

    public void addCompany(Company company) {
        companyRepo.save(company);
    }

    public void updateCompany(Company company) {
        companyRepo.save(company);
    }

    public void deleteCompany(int companyId) {
        companyRepo.deleteById((long) companyId);
    }
//    getCompany(Long userId)
//
//updateCompany(CompanyDto dto, Long userId)
//
//uploadLogo(MultipartFile file)
}
