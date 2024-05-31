package com.poornima.placement.service;

import com.poornima.placement.dto.CompanyDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface CompanyService {

    List<CompanyDTO> getAllCompanies();

    CompanyDTO getCompanyById(String id);

    CompanyDTO addCompany(CompanyDTO companyDTO);

    CompanyDTO updateCompany(String id, CompanyDTO companyDTO);

    void deleteCompany(String id);

}


