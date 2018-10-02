package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.nouhoun.springboot.jwt.integration.config.JwtUser;
import com.nouhoun.springboot.jwt.integration.domain.Authority;
import com.nouhoun.springboot.jwt.integration.domain.User1;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User1 user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
