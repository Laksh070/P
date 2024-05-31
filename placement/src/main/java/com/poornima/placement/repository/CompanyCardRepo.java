package com.poornima.placement.repository;

import com.poornima.placement.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyCardRepo extends JpaRepository<Company, String> {


}
