package com.poornima.placement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CompanyDTO {

    private String companyid;
    private String companyname;
    private String visitDate;
    private String highestPackage;
    private int studentsPlaced;
    private String description;
    private List<String> interviewQuestions;

}
