package com.poornima.placement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company {

                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private long id;

                private String companyid;
                private String companyname;
                private String description;
                private String visitDate;
                private int studentsPlaced;
                private double highestPackage;

//                @ElementCollection
//                @CollectionTable(name = "interview_questions", joinColumns = @JoinColumn(name = "companyid"))
//                @Column(name = "question")
                private List<String> interviewQuestions;


}


