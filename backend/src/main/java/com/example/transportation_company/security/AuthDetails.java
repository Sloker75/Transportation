package com.example.transportation_company.security;

import com.example.transportation_company.entity.AuthData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class AuthDetails implements UserDetails {
    private final AuthData authData;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(authData.getRole()).map(role -> new SimpleGrantedAuthority("Role_" + role.toString())).toList();
    }

    @Override
    public String getPassword() {
        return authData.getPassword();
    }

    @Override
    public String getUsername() {
        return authData.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return authData.isEnabled();
    }
}
