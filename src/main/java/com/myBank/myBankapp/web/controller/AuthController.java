package com.myBank.myBankapp.web.controller;

import com.myBank.myBankapp.service.dto.LoginDto;
import com.myBank.myBankapp.web.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);//Internal: AuthProvider -> OurUserDetailsService...then

        //If pass to this line, means the user is correctly autheticated
        System.out.println(authentication.isAuthenticated());//Verify if is authenticated
        System.out.println(authentication.getPrincipal());//User that start session

        String jwt = this.jwtUtil.create(loginDto.getUsername());
        //Status ok with authorization header
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,jwt).build();

    }
}
