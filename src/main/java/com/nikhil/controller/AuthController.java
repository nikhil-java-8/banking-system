package com.nikhil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.entity.Banker;
import com.nikhil.repository.BankerRepository;
import com.nikhil.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private BankerRepository bankerRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody Banker request) {

        Banker banker = bankerRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Banker not found"));

        if (!banker.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(banker.getUsername());
    }
}