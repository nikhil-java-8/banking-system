package com.nikhil.security;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.nikhil.entity.Banker;
import com.nikhil.repository.BankerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private BankerRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Banker banker = repo.findByUsername(username)
    	        .orElseThrow(() -> new RuntimeException("Banker not found"));
        if (banker == null) {
            throw new RuntimeException("Banker not found");
        }
        return new org.springframework.security.core.userdetails.User(
                banker.getUsername(),
                banker.getPassword(),
                List.of(new SimpleGrantedAuthority(banker.getRole()))
        );
    }
}
