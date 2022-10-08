package com.example.transportation_company.security;

import com.example.transportation_company.repository.AuthDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DatabaseUserService implements UserDetailsService {

    private final AuthDataRepository authDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authDataRepository.findByEmail(username).map(authData -> new AuthDetails(authData)).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
