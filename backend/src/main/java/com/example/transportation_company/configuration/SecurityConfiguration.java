package com.example.transportation_company.configuration;

import com.example.transportation_company.security.*;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final DatabaseUserService databaseUserService;
    private final AuthenticationSuccessHandler authenticationSuccess;
    private final AuthenticationFailureHandler authenticationFailure;
    private final LogoutSuccessHandler LogoutSuccess;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .antMatchers("/api/auth/login").permitAll()
                .antMatchers("/api/auth/logout").permitAll()
                .antMatchers("/api/auth/signup").permitAll()
                .antMatchers("/api/auth/verification").permitAll()
                .anyRequest().authenticated());
        http.csrf().disable().cors().and().logout().logoutUrl("/api/auth/logout").logoutSuccessHandler(LogoutSuccess);
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(databaseUserService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JsonAuthentificationFilter authentificationFilter(){
        JsonAuthentificationFilter authentificationFilter = new JsonAuthentificationFilter();
        authentificationFilter.setAuthenticationSuccessHandler(authenticationSuccess);
        authentificationFilter.setAuthenticationFailureHandler(authenticationFailure);
        authentificationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/auth/login"));
        authentificationFilter.setAuthenticationManager(authenticationManager());

        return authentificationFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(authProvider());
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().antMatchers("/swagger", "/swagger-ui/**", "/v3/**");
    }

}
