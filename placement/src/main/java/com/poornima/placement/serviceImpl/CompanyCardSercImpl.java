package com.poornima.placement.serviceImpl;

import com.poornima.placement.dto.CompanyDTO;
import com.poornima.placement.entity.Company;
import com.poornima.placement.repository.CompanyCardRepo;
import com.poornima.placement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CompanyCardSercImpl implements CompanyService {

    @Autowired
    private CompanyCardRepo companyCardRepo;


    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyCardRepo.findAll();
        return companies.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public CompanyDTO getCompanyById(String id) {
        Company company = companyCardRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
        return convertToDTO(company);
    }

    @Override
    public CompanyDTO addCompany(CompanyDTO companyDTO) {
//        String logoFileName = logoService.storeLogo(logoFile);
////        companyDTO.setLogo(logoFileName);
        Company company = convertToEntity(companyDTO);
        Company savedCompany = companyCardRepo.save(company);
        return convertToDTO(savedCompany);
    }

    @Override
    public CompanyDTO updateCompany(String id, CompanyDTO companyDTO) {
        Company existingCompany = companyCardRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));

        // Update existing company fields
        existingCompany.setCompanyname(companyDTO.getCompanyname());
        existingCompany.setDescription(companyDTO.getDescription());
        existingCompany.setVisitDate(companyDTO.getVisitDate());
        existingCompany.setStudentsPlaced(companyDTO.getStudentsPlaced());
        existingCompany.setHighestPackage(Double.parseDouble(companyDTO.getHighestPackage()));
        existingCompany.setInterviewQuestions(companyDTO.getInterviewQuestions());

        Company updatedCompany = companyCardRepo.save(existingCompany);
        return convertToDTO(updatedCompany);
    }

    @Override
    public void deleteCompany(String id) {
        companyCardRepo.deleteById(id);
    }

    public void saveImage(MultipartFile logo) {

    }

    // Convert methods
    private Company convertToEntity(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setCompanyname(companyDTO.getCompanyname());
        company.setDescription(companyDTO.getDescription());
        company.setVisitDate(companyDTO.getVisitDate());
        company.setStudentsPlaced(companyDTO.getStudentsPlaced());
        company.setHighestPackage(Double.parseDouble(companyDTO.getHighestPackage()));
        company.setInterviewQuestions(companyDTO.getInterviewQuestions());
//        company.setLogo(companyDTO.getLogo());
        return company;
    }

    private CompanyDTO convertToDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompanyid(company.getCompanyid());
        companyDTO.setCompanyname(company.getCompanyname());
        companyDTO.setDescription(company.getDescription());
        companyDTO.setVisitDate(company.getVisitDate());
        companyDTO.setStudentsPlaced(company.getStudentsPlaced());
        companyDTO.setHighestPackage(String.valueOf(company.getHighestPackage()));
        companyDTO.setInterviewQuestions(company.getInterviewQuestions());
//        companyDTO.setLogo(company.getLogo());
        return companyDTO;
    }

}
