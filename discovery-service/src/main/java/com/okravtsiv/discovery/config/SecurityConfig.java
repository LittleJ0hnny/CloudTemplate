package com.okravtsiv.discovery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${spring.security.user.name}")
    private String discoveryServiceLogin;

    @Value("${spring.security.user.password}")
    private String discoveryServicePassword;

    @Value("${spring.security.user.roles}")
    private String discoveryServiceRoles;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(discoveryServiceLogin)
                .password("{noop}" + discoveryServicePassword)
                .roles(discoveryServiceRoles);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .hasRole(discoveryServiceRoles)
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }
}
