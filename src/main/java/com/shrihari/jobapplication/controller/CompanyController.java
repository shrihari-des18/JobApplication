package com.shrihari.jobapplication.controller;

import com.shrihari.jobapplication.model.Company;
import com.shrihari.jobapplication.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("company/{companyId}")
    public Company getCompany(@PathVariable("companyId") int companyId) {
        return companyService.getCompany(companyId);
    }

    @PostMapping(path = "company", consumes = {"application/json"})
    public Company addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return companyService.getCompany(company.getCompanyId());
    }

    @PutMapping("company")
    public Company updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
        return companyService.getCompany(company.getCompanyId());
    }

    @DeleteMapping("company/{companyId}")
    public String deleteCompany(@PathVariable("companyId") int companyId) {
        companyService.deleteCompany(companyId);
        return "Deleted";
    }
}

