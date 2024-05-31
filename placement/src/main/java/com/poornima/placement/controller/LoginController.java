package com.poornima.placement.controller;

import com.poornima.placement.dto.LoginDto;
import com.poornima.placement.dto.SignUpDto;
import com.poornima.placement.entity.Company;
import com.poornima.placement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(loginService.login(loginDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpDto dto){
        return new ResponseEntity<>(HttpStatus.OK,loginService.signup(dto));
    }

}
