package com.poornima.placement.service;

import com.poornima.placement.dto.LoginDto;
import com.poornima.placement.dto.SignUpDto;
import com.poornima.placement.entity.Company;
import com.poornima.placement.entity.User;
import com.poornima.placement.repository.CompanyCardRepo;
import com.poornima.placement.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private CompanyCardRepo companyCardRepo;

    public HttpStatus login(LoginDto loginDto) {
        User user = loginRepository.findByEmail(loginDto.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getRole());
        System.out.println(user);
        if (user.getPassword().equals(loginDto.getPassword())) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.UNAUTHORIZED;
        }
    }

    public HttpStatus signup(SignUpDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setPassword(dto.getPassword());
        loginRepository.save(user);
        return HttpStatus.CREATED;
    }


}
